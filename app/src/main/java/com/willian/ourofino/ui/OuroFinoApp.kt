package com.willian.ourofino.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.willian.ourofino.R
import com.willian.ourofino.ui.screens.AboutScreen
import com.willian.ourofino.ui.screens.AttractionsScreen
import com.willian.ourofino.ui.screens.CaminhoScreen
import com.willian.ourofino.ui.screens.GastronomiaScreen
import com.willian.ourofino.ui.screens.HistoryScreen
import com.willian.ourofino.ui.screens.HomeScreen
import com.willian.ourofino.ui.screens.MaisScreen
import com.willian.ourofino.ui.screens.MapScreen

sealed class Rota(val rota: String, val rotulo: String, val icone: Int) {
    object Inicio : Rota("inicio", "Início", R.drawable.ic_home)
    object Historia : Rota("historia", "História", R.drawable.ic_history)
    object Atracoes : Rota("atracoes", "Atrações", R.drawable.ic_location)
    object Mapa : Rota("mapa", "Mapa", R.drawable.ic_map)
    object Mais : Rota("mais", "Mais", R.drawable.ic_more)
    object Caminho : Rota("caminho", "Caminho da Fé", R.drawable.ic_caminho)
    object Gastronomia : Rota("gastronomia", "Gastronomia", R.drawable.ic_restaurant)
    object Sobre : Rota("sobre", "Sobre", R.drawable.ic_info)
}

private val abas = listOf(Rota.Inicio, Rota.Historia, Rota.Atracoes, Rota.Mapa, Rota.Mais)

// Telas abertas a partir de "Mais": a aba Mais continua marcada enquanto elas estão visíveis.
private val rotasDeMais = setOf(Rota.Mais.rota, Rota.Caminho.rota, Rota.Gastronomia.rota, Rota.Sobre.rota)

private fun NavHostController.irPara(rota: Rota) {
    navigate(rota.rota) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

private fun NavHostController.abrir(rota: Rota) {
    navigate(rota.rota) { launchSingleTop = true }
}

@Composable
fun OuroFinoApp() {
    val navController = rememberNavController()
    var focoMapa by remember { mutableStateOf<String?>(null) }
    val entradaAtual by navController.currentBackStackEntryAsState()
    val destinoAtual = entradaAtual?.destination

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            NavigationBar {
                abas.forEach { aba ->
                    val selecionada = if (aba == Rota.Mais) {
                        destinoAtual?.route in rotasDeMais
                    } else {
                        destinoAtual?.hierarchy?.any { it.route == aba.rota } == true
                    }
                    NavigationBarItem(
                        icon = { Icon(painterResource(id = aba.icone), contentDescription = aba.rotulo) },
                        label = { Text(aba.rotulo) },
                        selected = selecionada,
                        onClick = { navController.irPara(aba) }
                    )
                }
            }
        }
    ) { interno ->
        NavHost(
            navController = navController,
            startDestination = Rota.Inicio.rota,
            modifier = Modifier.padding(interno)
        ) {
            composable(Rota.Inicio.rota) {
                HomeScreen(
                    onVerAtracoes = { navController.irPara(Rota.Atracoes) },
                    onVerHistoria = { navController.irPara(Rota.Historia) },
                    onVerMapa = { navController.irPara(Rota.Mapa) },
                    onVerCaminho = { navController.abrir(Rota.Caminho) },
                    onVerGastronomia = { navController.abrir(Rota.Gastronomia) }
                )
            }
            composable(Rota.Historia.rota) { HistoryScreen() }
            composable(Rota.Atracoes.rota) {
                AttractionsScreen(
                    onVerNoMapa = { id ->
                        focoMapa = id
                        navController.irPara(Rota.Mapa)
                    }
                )
            }
            composable(Rota.Mapa.rota) { MapScreen(focoId = focoMapa) }
            composable(Rota.Mais.rota) {
                MaisScreen(
                    onGastronomia = { navController.abrir(Rota.Gastronomia) },
                    onCaminho = { navController.abrir(Rota.Caminho) },
                    onSobre = { navController.abrir(Rota.Sobre) }
                )
            }
            composable(Rota.Caminho.rota) {
                CaminhoScreen(
                    onVerMenino = {
                        focoMapa = "menino-porteira"
                        navController.irPara(Rota.Mapa)
                    },
                    onVoltar = { navController.popBackStack() }
                )
            }
            composable(Rota.Gastronomia.rota) {
                GastronomiaScreen(onVoltar = { navController.popBackStack() })
            }
            composable(Rota.Sobre.rota) {
                AboutScreen(onVoltar = { navController.popBackStack() })
            }
        }
    }
}
