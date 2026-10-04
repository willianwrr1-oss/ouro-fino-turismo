package com.willian.ourofino.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.willian.ourofino.R
import com.willian.ourofino.data.Estabelecimento
import com.willian.ourofino.data.Gastronomia
import com.willian.ourofino.data.TipoLocal
import com.willian.ourofino.ui.components.ChipSimples
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.abrirLink

@Composable
fun GastronomiaScreen(onVoltar: () -> Unit) {
    var filtro by remember { mutableStateOf<TipoLocal?>(null) }
    val lista = Gastronomia.locais.filter { filtro == null || it.tipo == filtro }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HeroHeader(alturaMinima = 240.dp, onVoltar = onVoltar) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_restaurant),
                    contentDescription = null,
                    tint = Color(0xFFF3E3B3),
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextoOuroClaro("ONDE COMER E BEBER")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Gastronomia",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Restaurantes, pizzarias, cafés e bares de Ouro Fino.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        item {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = Gastronomia.introducao,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    Text(
                        text = Gastronomia.aviso,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item { ChipSimples("Todos", filtro == null) { filtro = null } }
                items(TipoLocal.values().toList()) { t ->
                    ChipSimples(t.rotulo, filtro == t) { filtro = t }
                }
            }
        }

        items(lista) { local ->
            CartaoLocal(local)
        }

        item {
            Text(
                text = Gastronomia.fontes,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Composable
private fun CartaoLocal(local: Estabelecimento) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 14.dp, bottom = 6.dp)) {
            Text(
                text = local.tipo.rotulo.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = local.nome,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = local.descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            val endereco = local.endereco
            if (endereco != null) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = endereco,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(
                    onClick = {
                        context.abrirLink(
                            "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(local.consultaMapa)
                        )
                    }
                ) { Text("Abrir no Maps") }
            }
        }
    }
}
