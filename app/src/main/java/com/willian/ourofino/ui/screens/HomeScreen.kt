package com.willian.ourofino.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.ui.components.FotoDoPonto
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.TituloDeSecao

@Composable
fun HomeScreen(
    onVerAtracoes: () -> Unit,
    onVerHistoria: () -> Unit,
    onVerMapa: () -> Unit
) {
    val destaques = OuroFinoDados.pontos.filter { it.destaque }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 28.dp)
    ) {
        item {
            Column {
            HeroHeader(alturaMinima = 300.dp) {
                TextoOuroClaro("SUL DE MINAS · CIRCUITO DAS MALHAS")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ouro Fino",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 48.sp, lineHeight = 54.sp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Terra do Menino da Porteira",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFF3E3B3)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "Um arraial de garimpo de 1749 que virou cidade histórica, de cafezais, malhas e esculturas gigantes.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
            }
        }

        item {
            Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CartaoNumero(valor = "1749", rotulo = "paróquia criada", modifier = Modifier.weight(1f))
                CartaoNumero(valor = "908 m", rotulo = "de altitude", modifier = Modifier.weight(1f))
                CartaoNumero(valor = "≈ 33 mil", rotulo = "habitantes (IBGE, 2020)", modifier = Modifier.weight(1f))
            }
            }
        }

        item {
            Column {
            TituloDeSecao("Conheça a cidade")
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Ouro Fino nasceu na década de 1740, quando bandeirantes encontraram ouro nos ribeirões da região. " +
                    "No século XX, o café impulsionou a economia. Hoje a cidade combina patrimônio histórico, indústria de malhas, " +
                    "ecoturismo e os monumentos inspirados na canção “O Menino da Porteira”.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            }
        }

        item {
            Column {
            Spacer(modifier = Modifier.height(28.dp))
            TituloDeSecao("Destaques")
            Spacer(modifier = Modifier.height(14.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(destaques) { ponto ->
                    Card(
                        modifier = Modifier
                            .width(270.dp)
                            .clickable(onClick = onVerAtracoes),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                    ) {
                        FotoDoPonto(ponto = ponto, altura = 150.dp)
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = ponto.nome,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 2
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = ponto.resumo,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2
                            )
                        }
                    }
                }
            }
            }
        }

        item {
            Column {
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onVerMapa,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Explorar no mapa", modifier = Modifier.padding(vertical = 6.dp))
                }
                OutlinedButton(
                    onClick = onVerHistoria,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Ler a história da cidade", modifier = Modifier.padding(vertical = 6.dp))
                }
            }
            }
        }
    }
}

@Composable
private fun CartaoNumero(valor: String, rotulo: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = valor,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = rotulo,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}
