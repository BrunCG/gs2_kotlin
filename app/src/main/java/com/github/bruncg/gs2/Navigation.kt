package com.github.bruncg.gs2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.bruncg.gs2.screens.EquipeScreen
import com.github.bruncg.gs2.screens.ImcScreen
import com.github.bruncg.gs2.screens.LoginScreen
import com.github.bruncg.gs2.screens.MenuScreen

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Menu : Screen("menu_screen")
    object Imc : Screen("imc_screen")
    object Equipe : Screen("equipe_screen")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
        composable(Screen.Imc.route) {
            ImcScreen(navController = navController)
        }
        composable(Screen.Equipe.route) {
            EquipeScreen(navController = navController)
        }
    }
}

