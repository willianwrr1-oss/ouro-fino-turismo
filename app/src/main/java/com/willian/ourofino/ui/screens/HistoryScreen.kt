package com.willian.ourofino.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.willian.ourofino.R
import com.willian.ourofino.data.repository.LocalDataRepository

@Composable
fun HistoryScreen() {
    val scrollState = rememberScrollState()
    val historia = LocalDataRepository.getHistoriaCompleta()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = stringResource(R.string.history_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Timeline sections
        HistorySectionCard(
            title = historia.descoberta.titulo,
            content = historia.descoberta.conteudo,
            icon = "🔍",
            color = MaterialTheme.colorScheme.primary
        )

        HistorySectionCard(
            title = historia.fundacao.titulo,
            content = historia.fundacao.conteudo,
            icon = "🏘️",
            color = MaterialTheme.colorScheme.secondary
        )

        HistorySectionCard(
            title = historia.cicloOuro.titulo,
            content = historia.cicloOuro.conteudo,
            icon = "✨",
            color = MaterialTheme.colorScheme.primary
        )

        HistorySectionCard(
            title = historia.transformacao.titulo,
            content = historia.transformacao.conteudo,
            icon = "🌟",
            color = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun HistorySectionCard(
    title: String,
    content: String,
    icon: String,
    color: androidx.compose.ui.graphics.Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = icon,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = color.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = content,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
