package com.willian.ourofino.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.willian.ourofino.R
import com.willian.ourofino.data.model.Categoria
import com.willian.ourofino.data.repository.LocalDataRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttractionsScreen(navController: NavController) {
    var selectedCategory by remember { mutableStateOf(Categoria.CULTURAL) }
    val pontos = LocalDataRepository.getPontosturisticos()
    val filteredPontos = pontos.filter { it.category == selectedCategory }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Title and Filter
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.attractions_title),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Filter buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Categoria.values().forEach { category ->
                    val label = when (category) {
                        Categoria.CULTURAL -> stringResource(R.string.attractions_cultural)
                        Categoria.NATURAL -> stringResource(R.string.attractions_natural)
                        Categoria.RELIGIOUS -> stringResource(R.string.attractions_religious)
                    }
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        label = { Text(label, fontSize = 12.sp) }
                    )
                }
            }
        }

        // List of attractions
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(filteredPontos) { ponto ->
                AttractionCard(ponto)
            }
        }
    }
}

@Composable
fun AttractionCard(ponto: com.willian.ourofino.data.model.PontoTuristico) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            // Image
            if (ponto.imageUrl.isNotEmpty()) {
                AsyncImage(
                    model = ponto.imageUrl,
                    contentDescription = stringResource(ponto.nameRes),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Sem imagem disponível")
                }
            }

            // Content
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(ponto.nameRes),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(ponto.descriptionRes),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Coordinates
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📍 ${ponto.latitude.toStringWithDecimals(4)}, ${ponto.longitude.toStringWithDecimals(4)}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    IconButton(
                        onClick = { /* TODO: Open in Maps */ },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Text("🗺️", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

private fun Double.toStringWithDecimals(decimals: Int): String {
    return "%.${decimals}f".format(this)
}
