package com.github.bruncg.gs2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.bruncg.gs2.Screen

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MENU", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate(Screen.Imc.route) }) {
            Text("Cálculo de IMC")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(Screen.Equipe.route) }) {
            Text("Equipe")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Menu.route) { inclusive = true }
            }
        }) {
            Text("Voltar")
        }
    }
}