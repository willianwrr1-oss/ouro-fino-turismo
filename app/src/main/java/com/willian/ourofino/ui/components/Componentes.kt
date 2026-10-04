package com.willian.ourofino.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.willian.ourofino.data.Categoria
import com.willian.ourofino.data.Foto
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.data.PontoTuristico
import com.willian.ourofino.ui.theme.HeroBrush
import com.willian.ourofino.ui.theme.OuroClaro

fun Context.abrirLink(url: String) {
    try {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    } catch (e: Exception) {
        // Nenhum aplicativo capaz de abrir o link.
    }
}

fun Context.abrirEmail(email: String, assunto: String) {
    try {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            .putExtra(Intent.EXTRA_SUBJECT, assunto)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    } catch (e: Exception) {
        // Nenhum aplicativo de e-mail instalado.
    }
}

fun urlComoChegar(p: PontoTuristico): String {
    val lat = p.latitude
    val lon = p.longitude
    return if (lat != null && lon != null) {
        "https://www.google.com/maps/dir/?api=1&destination=$lat,$lon"
    } else {
        "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(p.consultaMapa)
    }
}

/** Fotos próprias: arquivos app/src/main/res/drawable-nodpi/foto_<id com underline>.jpg (ex.: foto_santuario.jpg). Retorna 0 se não existir. */
fun Context.fotoLocalDe(p: PontoTuristico): Int =
    resources.getIdentifier("foto_" + p.id.replace('-', '_'), "drawable", packageName)

fun urlFotosNoMapa(p: PontoTuristico): String =
    "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(p.consultaMapa)

fun categoriaBrush(c: Categoria): Brush = when (c) {
    Categoria.MONUMENTO -> Brush.linearGradient(listOf(Color(0xFF6B4508), Color(0xFFC9971C)))
    Categoria.RELIGIOSO -> Brush.linearGradient(listOf(Color(0xFF2A2F5B), Color(0xFF6C6FB5)))
    Categoria.NATUREZA -> Brush.linearGradient(listOf(Color(0xFF1F4D3A), Color(0xFF5FA37B)))
}

@Composable
fun HeroHeader(
    modifier: Modifier = Modifier,
    foto: Foto? = null,
    alturaMinima: Dp = 200.dp,
    onVoltar: (() -> Unit)? = null,
    conteudo: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = alturaMinima)
            .background(HeroBrush)
    ) {
        if (foto != null) {
            AsyncImage(
                model = foto.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Brush.verticalGradient(listOf(Color(0x55000000), Color(0xE61F1507))))
            )
            Text(
                text = foto.legenda,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .statusBarsPadding()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
        if (onVoltar != null) {
            Text(
                text = "‹ Voltar",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .statusBarsPadding()
                    .clickable(onClick = onVoltar)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .statusBarsPadding()
                .padding(start = 20.dp, end = 20.dp, top = 56.dp, bottom = 22.dp),
            content = conteudo
        )
    }
}

@Composable
fun TituloDeSecao(texto: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Text(
            text = texto,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(3.dp)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(2.dp))
        )
    }
}

@Composable
fun ChipSimples(texto: String, selecionado: Boolean, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(50),
        color = if (selecionado) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        contentColor = if (selecionado) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
        shadowElevation = 2.dp,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 9.dp)
        )
    }
}

@Composable
fun SeloCategoria(c: Categoria) {
    Surface(
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Text(
            text = c.rotulo.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun FotoDoPonto(ponto: PontoTuristico, altura: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(altura)
            .background(categoriaBrush(ponto.categoria))
    ) {
        Icon(
            imageVector = Icons.Filled.Place,
            contentDescription = null,
            tint = Color.White.copy(alpha = 0.35f),
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp)
        )
        val context = LocalContext.current
        val fotoLocal = remember(ponto.id) { context.fotoLocalDe(ponto) }
        val foto = ponto.foto
        if (fotoLocal != 0) {
            AsyncImage(
                model = fotoLocal,
                contentDescription = ponto.nome,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            LegendaDaFoto("Foto: " + OuroFinoDados.CREDITO_FOTOS_PROPRIAS, Modifier.align(Alignment.BottomStart))
        } else if (foto != null) {
            AsyncImage(
                model = foto.url,
                contentDescription = ponto.nome,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            LegendaDaFoto(foto.legenda, Modifier.align(Alignment.BottomStart))
        }
    }
}

@Composable
private fun LegendaDaFoto(texto: String, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        color = Color.White,
        fontSize = 10.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(Color.Transparent, Color(0xAA000000))))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    )
}

@Composable
fun TextoOuroClaro(texto: String, modifier: Modifier = Modifier) {
    Text(
        text = texto,
        style = MaterialTheme.typography.labelSmall,
        color = OuroClaro,
        modifier = modifier
    )
}
