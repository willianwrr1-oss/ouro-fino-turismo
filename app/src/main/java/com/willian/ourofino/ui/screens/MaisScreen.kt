package com.willian.ourofino.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.willian.ourofino.R
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro

@Composable
fun MaisScreen(
    onGastronomia: () -> Unit,
    onCaminho: () -> Unit,
    onSobre: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        HeroHeader(alturaMinima = 200.dp) {
            TextoOuroClaro("EXPLORE MAIS")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Mais sobre Ouro Fino",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            ItemMenu(
                icone = R.drawable.ic_restaurant,
                titulo = "Gastronomia",
                subtitulo = "Restaurantes, pizzarias, cafés e bares",
                onClick = onGastronomia
            )
            ItemMenu(
                icone = R.drawable.ic_caminho,
                titulo = "Caminho da Fé",
                subtitulo = "A rota de peregrinação que passa por Ouro Fino",
                onClick = onCaminho
            )
            ItemMenu(
                icone = R.drawable.ic_info,
                titulo = "Sobre e privacidade",
                subtitulo = "Desenvolvimento, créditos e proteção de dados",
                onClick = onSobre
            )
        }
    }
}

@Composable
private fun ItemMenu(icone: Int, titulo: String, subtitulo: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 3.dp
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Icon(
                    painter = painterResource(id = icone),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(26.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitulo,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
