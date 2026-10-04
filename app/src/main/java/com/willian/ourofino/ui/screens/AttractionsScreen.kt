package com.willian.ourofino.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp
import com.willian.ourofino.data.Categoria
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.data.PontoTuristico
import com.willian.ourofino.ui.components.ChipSimples
import com.willian.ourofino.ui.components.FotoDoPonto
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.SeloCategoria
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.TituloDeSecao
import com.willian.ourofino.ui.components.abrirLink
import com.willian.ourofino.ui.components.urlComoChegar
import com.willian.ourofino.ui.components.urlFotosNoMapa

@Composable
fun AttractionsScreen(onVerNoMapa: (String) -> Unit) {
    var filtro by remember { mutableStateOf<Categoria?>(null) }

    val destaques = OuroFinoDados.pontos.filter { it.destaque && (filtro == null || it.categoria == filtro) }
    val outros = OuroFinoDados.pontos.filter { !it.destaque && (filtro == null || it.categoria == filtro) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HeroHeader(alturaMinima = 220.dp) {
                TextoOuroClaro("O QUE VISITAR")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Atrações",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Monumentos, fé e natureza em Ouro Fino.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item { ChipSimples("Todas", filtro == null) { filtro = null } }
                items(Categoria.values().toList()) { c ->
                    ChipSimples(c.rotulo, filtro == c) { filtro = c }
                }
            }
        }

        items(destaques) { ponto ->
            CartaoAtracao(ponto = ponto, onVerNoMapa = onVerNoMapa)
        }

        if (outros.isNotEmpty()) {
            item {
                Column {
                    TituloDeSecao("Outros pontos de interesse")
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        outros.forEach { ponto -> LinhaCompacta(ponto) }
                    }
                }
            }
        }

        item {
            Text(
                text = "As fotos vêm do Wikimedia Commons, com crédito do autor e licença. Onde não há foto livre disponível, " +
                    "use “Ver fotos no Google Maps”.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Composable
private fun CartaoAtracao(ponto: PontoTuristico, onVerNoMapa: (String) -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        FotoDoPonto(ponto = ponto, altura = 200.dp)
        Column(modifier = Modifier.padding(18.dp)) {
            SeloCategoria(ponto.categoria)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = ponto.nome,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = ponto.descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            val endereco = ponto.endereco
            if (endereco != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = endereco,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                if (ponto.temCoordenadas) {
                    OutlinedButton(
                        onClick = { onVerNoMapa(ponto.id) },
                        shape = RoundedCornerShape(12.dp)
                    ) { Text("Ver no mapa") }
                }
                Button(
                    onClick = { context.abrirLink(urlComoChegar(ponto)) },
                    shape = RoundedCornerShape(12.dp)
                ) { Text("Como chegar") }
            }
            if (ponto.foto == null) {
                TextButton(onClick = { context.abrirLink(urlFotosNoMapa(ponto)) }) {
                    Text("Ver fotos no Google Maps")
                }
            }
        }
    }
}

@Composable
private fun LinhaCompacta(ponto: PontoTuristico) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 6.dp, top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = ponto.nome,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = ponto.categoria.rotulo,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            TextButton(onClick = { context.abrirLink(urlComoChegar(ponto)) }) {
                Text("Mapa")
            }
        }
    }
}
