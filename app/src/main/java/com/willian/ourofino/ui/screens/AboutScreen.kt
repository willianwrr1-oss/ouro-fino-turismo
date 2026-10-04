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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.willian.ourofino.data.Foto
import com.willian.ourofino.data.OuroFinoDados
import com.willian.ourofino.ui.components.HeroHeader
import com.willian.ourofino.ui.components.TextoOuroClaro
import com.willian.ourofino.ui.components.TituloDeSecao
import com.willian.ourofino.ui.components.abrirEmail
import com.willian.ourofino.ui.components.abrirLink

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    val versao = remember {
        try {
            context.packageManager.getPackageInfo(context.packageName, 0).versionName ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 28.dp)
    ) {
        item {
            HeroHeader(alturaMinima = 220.dp) {
                TextoOuroClaro("SOBRE O APLICATIVO")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ouro Fino Turismo",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = if (versao.isNotEmpty()) "Versão $versao" else "Guia de história e turismo",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                TituloDeSecao("Desenvolvimento")
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(18.dp),
                    color = MaterialTheme.colorScheme.surface,
                    shadowElevation = 3.dp
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Desenvolvido por Willian R Rocha",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Text(
                                text = "Contato: ",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = OuroFinoDados.EMAIL_CONTATO,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    context.abrirEmail(OuroFinoDados.EMAIL_CONTATO, "Aplicativo Ouro Fino Turismo")
                                }
                            )
                        }
                    }
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Sobre o conteúdo")
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "O texto da história foi escrito com base em fontes oficiais (IBGE, Prefeitura de Ouro Fino e Senado Federal). " +
                        "As coordenadas vêm de dados públicos de mapas e podem variar alguns metros; para navegar, use o botão Como chegar.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Créditos das fotos")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    CreditoFoto("Monumento Menino da Porteira", OuroFinoDados.fotoMenino)
                    CreditoFoto("Vista de Ouro Fino (tela História)", OuroFinoDados.fotoCidade)
                    Text(
                        text = "Demais fotos, quando houver: acervo de " + OuroFinoDados.CREDITO_FOTOS_PROPRIAS + ".",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item {
            Column {
                Spacer(modifier = Modifier.height(28.dp))
                TituloDeSecao("Mapa e bibliotecas")
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Mapa: © OpenStreetMap contributors, exibido com osmdroid.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.clickable { context.abrirLink("https://www.openstreetmap.org/copyright") }
                    )
                    Text(
                        text = "Imagens: Coil. Interface: Jetpack Compose e Material 3.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun CreditoFoto(titulo: String, foto: Foto) {
    val context = LocalContext.current
    Column {
        Text(
            text = titulo,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = foto.autor,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "Licença " + foto.licenca,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { context.abrirLink(foto.licencaUrl) }
            )
            Text(
                text = "Página original",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { context.abrirLink(foto.paginaOrigem) }
            )
        }
    }
}
