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

@Composable
fun EquipeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "EQUIPE", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Integrantes:", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // PREENCHA AQUI COM OS NOMES
        Text("Bruno de Castro Granado - RM551411")
        Text("Lucas Henrique de Melo Silva - RM550175")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Voltar")
        }
    }
}