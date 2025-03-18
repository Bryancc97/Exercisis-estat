package com.example.exercicisstateless

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Numerosecreto() {
    var numero: String by remember { mutableStateOf("") }
    var numerorandom: Int by remember { mutableIntStateOf(Random.nextInt(0, 101)) }
    var mensaje: String by remember { mutableStateOf("") }
    var intentos: Int by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Adivina el número entre 0 y 100", fontSize = 20.sp)
        TextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text("Ingresa un número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            val numeroInt = numero.toIntOrNull()
            if (numeroInt != null) {
                intentos++ // Contador de intentos
                mensaje = when {
                    numeroInt < numerorandom -> "El número es más grande"
                    numeroInt > numerorandom -> "El número es más pequeño"
                    else -> {
                        val resultMessage = "Acertaste y solo te costo $intentos intentos...."
                        numerorandom = Random.nextInt(0, 101)
                        // Reinicia el contador de intentos
                        intentos = 0
                        resultMessage
                    }
                }
            } else {
                mensaje = "Por favor, ingresa un número válido."
            }
        }) {
            Text(text = "Adivinar")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = mensaje, fontSize = 18.sp)
    }
}