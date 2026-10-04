package com.willian.ourofino.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.ui.components.ChipSimples
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.abrirLink
import com.willian.ourofino.ui.components.urlComoChegar
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import java.io.File

@Composable
fun MapScreen(focoId: String?) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val pontos = remember { OuroFinoDados.pontos.filter { it.temCoordenadas } }
    var selecionado by remember { mutableStateOf<String?>(focoId) }

    LaunchedEffect(focoId) {
        if (focoId != null) selecionado = focoId
    }

    val mapView = remember {
        val cfg = Configuration.getInstance()
        cfg.load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
        cfg.setUserAgentValue(context.packageName)
        cfg.setOsmdroidBasePath(File(context.cacheDir, "osmdroid"))
        cfg.setOsmdroidTileCache(File(context.cacheDir, "osmdroid/tiles"))

        val mapa = MapView(context)
        mapa.setTileSource(TileSourceFactory.MAPNIK)
        mapa.setMultiTouchControls(true)
        mapa.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
        mapa.minZoomLevel = 5.0
        mapa.maxZoomLevel = 19.0
        mapa.controller.setZoom(15.0)
        mapa.controller.setCenter(GeoPoint(OuroFinoDados.CENTRO_LAT, OuroFinoDados.CENTRO_LON))

        pontos.forEach { p ->
            val marcador = Marker(mapa)
            marcador.position = GeoPoint(p.latitude ?: 0.0, p.longitude ?: 0.0)
            marcador.title = p.nome
            marcador.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marcador.setOnMarkerClickListener { _, _ ->
                selecionado = p.id
                true
            }
            mapa.overlays.add(marcador)
        }
        mapa
    }

    DisposableEffect(lifecycleOwner, mapView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        mapView.onResume()
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            mapView.onPause()
            mapView.onDetach()
        }
    }

    LaunchedEffect(selecionado) {
        val p = pontos.firstOrNull { it.id == selecionado }
        if (p != null) {
            mapView.controller.setZoom(17.0)
            mapView.controller.animateTo(GeoPoint(p.latitude ?: 0.0, p.longitude ?: 0.0))
        }
    }

    val pontoSelecionado = pontos.firstOrNull { it.id == selecionado }

    Column(modifier = Modifier.fillMaxSize()) {
        HeroHeader(alturaMinima = 120.dp) {
            TextoOuroClaro("MAPA INTERATIVO")
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Mapa de Ouro Fino",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }

        Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
            AndroidView(factory = { mapView }, modifier = Modifier.fillMaxSize())

            Text(
                text = "© OpenStreetMap contributors",
                fontSize = 10.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(Color.White.copy(alpha = 0.75f), RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                if (pontoSelecionado != null) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = pontoSelecionado.nome,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = pontoSelecionado.resumo,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                    onClick = { context.abrirLink(urlComoChegar(pontoSelecionado)) },
                                    shape = RoundedCornerShape(12.dp)
                                ) { Text("Como chegar") }
                                TextButton(onClick = { selecionado = null }) { Text("Fechar") }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(pontos) { p ->
                        ChipSimples(
                            texto = p.nome.removePrefix("Monumento "),
                            selecionado = p.id == selecionado,
                            onClick = { selecionado = p.id }
                        )
                    }
                }
            }
        }
    }
}
