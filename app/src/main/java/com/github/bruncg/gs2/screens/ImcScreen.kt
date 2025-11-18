package com.github.bruncg.gs2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ImcScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Resultado") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculadora IMC", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Seu nome") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Seu Peso (ex: 70.5)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Sua altura (ex: 1.75)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            val pesoVal = peso.replace(',', '.').toDoubleOrNull()
            val alturaVal = altura.replace(',', '.').toDoubleOrNull()

            if (nome.isNotBlank() && pesoVal != null && alturaVal != null && alturaVal > 0) {
                val imc = pesoVal / (alturaVal * alturaVal)
                resultado = "Olá $nome, seu IMC é ${String.format("%.2f", imc)}"
            } else {
                resultado = "Por favor, preencha todos os campos corretamente."
            }
        }) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultado, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Voltar")
        }
    }
}