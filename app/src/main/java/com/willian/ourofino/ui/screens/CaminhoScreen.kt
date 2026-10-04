package com.willian.ourofino.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.willian.ourofino.R
import com.willian.ourofino.data.CaminhoDaFe
import com.willian.ourofino.data.Dica
import com.willian.ourofino.data.EtapaCaminho
import com.willian.ourofino.data.Evento
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.TituloDeSecao
import com.willian.ourofino.ui.components.abrirLink

private val AmareloSeta = Color(0xFFF2C300)

private class ItemFoto(val modelo: Any, val legenda: String, val link: String?)

@Composable
fun CaminhoScreen(onVerMenino: () -> Unit) {
    val context = LocalContext.current

    // Fotos próprias (foto_caminho_1 ... foto_caminho_8) têm prioridade; o Commons completa as 3 primeiras posições.
    val fotos = remember {
        val lista = mutableListOf<ItemFoto>()
        for (i in 1..8) {
            val id = context.resources.getIdentifier("foto_caminho_$i", "drawable", context.packageName)
            if (id != 0) {
                lista.add(ItemFoto(id, "Foto: " + OuroFinoDados.CREDITO_FOTOS_PROPRIAS, null))
            } else if (i <= CaminhoDaFe.fotos.size) {
                val f = CaminhoDaFe.fotos[i - 1]
                lista.add(ItemFoto(f.url, f.legenda, f.paginaOrigem))
            }
        }
        lista.toList()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 28.dp)
    ) {
        item {
            HeroHeader(alturaMinima = 300.dp) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_caminho),
                    contentDescription = null,
                    tint = AmareloSeta,
                    modifier = Modifier.size(44.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextoOuroClaro("PEREGRINAÇÃO · SERRA DA MANTIQUEIRA")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Caminho da Fé",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 42.sp, lineHeight = 48.sp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Ouro Fino faz parte do trajeto que leva até Aparecida.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CaminhoDaFe.numeros.forEach { par ->
                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = par.first,
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = par.second,
                                    style = MaterialTheme.typography.labelSmall,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                TituloDeSecao("O que é o Caminho da Fé")
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = CaminhoDaFe.resumo,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Como nasceu")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CaminhoDaFe.marcos.forEach { marco -> CartaoMarco(marco) }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Ouro Fino no Caminho")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CaminhoDaFe.ouroFinoNoCaminho.forEach { d -> CartaoDica(d) }
                    OutlinedButton(
                        onClick = onVerMenino,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Ver o Menino da Porteira no mapa", modifier = Modifier.padding(vertical = 4.dp))
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("A rota tradicional")
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "De Águas da Prata a Aparecida. As distâncias são aproximadas, segundo relatos de peregrinos.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    CaminhoDaFe.etapas.forEachIndexed { indice, etapa ->
                        LinhaEtapa(etapa, indice == CaminhoDaFe.etapas.size - 1)
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Como fazer")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CaminhoDaFe.comoFazer.forEach { d -> CartaoDica(d) }
                    Button(
                        onClick = { context.abrirLink(CaminhoDaFe.SITE_OFICIAL) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Abrir o site oficial", modifier = Modifier.padding(vertical = 6.dp))
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Fotos")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    fotos.forEach { foto ->
                        Surface(
                            shape = RoundedCornerShape(18.dp),
                            color = MaterialTheme.colorScheme.surface,
                            shadowElevation = 3.dp
                        ) {
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                        .background(
                                            Brush.linearGradient(listOf(Color(0xFF1F4D3A), Color(0xFF5FA37B)))
                                        )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_caminho),
                                        contentDescription = null,
                                        tint = Color.White.copy(alpha = 0.4f),
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .size(56.dp)
                                    )
                                    AsyncImage(
                                        model = foto.modelo,
                                        contentDescription = foto.legenda,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Text(
                                        text = foto.legenda,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    val link = foto.link
                                    if (link != null) {
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = "Wikimedia Commons · autor e licença na página da foto",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.primary,
                                            textDecoration = TextDecoration.Underline,
                                            modifier = Modifier.clickable { context.abrirLink(link) }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Fontes")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CaminhoDaFe.fontes.forEach { fonte ->
                        Column {
                            Text(
                                text = fonte.titulo,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = fonte.detalhe,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CartaoMarco(marco: Evento) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = marco.data.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = marco.titulo,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = marco.texto,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun CartaoDica(dica: Dica) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = dica.titulo,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = dica.texto,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun LinhaEtapa(etapa: EtapaCaminho, ultima: Boolean) {
    val corPonto = if (etapa.destaque) AmareloSeta else MaterialTheme.colorScheme.primary
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(if (etapa.destaque) 18.dp else 12.dp)
                    .background(corPonto, CircleShape)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(
                    text = etapa.nome,
                    style = if (etapa.destaque) MaterialTheme.typography.titleLarge else MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                val nota = etapa.nota
                if (nota != null) {
                    Text(
                        text = nota,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        if (!ultima) Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.width(18.dp), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(if (etapa.ateProxima != null) 30.dp else 18.dp)
                        .background(MaterialTheme.colorScheme.outlineVariant)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            val trecho = etapa.ateProxima
            if (trecho != null) {
                Text(
                    text = trecho,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
