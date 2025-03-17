package com.example.exercicisstateless

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun CalcularIMC(){
    var nombre: String by remember { mutableStateOf("") }
    var any: String by remember { mutableStateOf("") }
    var altura: String by remember { mutableStateOf("") }
    var peso: String by remember { mutableStateOf("") }
    var resultado: String by remember { mutableStateOf("") }
    var showResult: Boolean by remember { mutableStateOf(false) }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre: ") })
        TextField(
            value = any,
            onValueChange = { any = it },
            label = { Text("Año de Nacimiento: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = altura, onValueChange = { altura = it }, label = { Text("Altura: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = peso, onValueChange = { peso = it }, label = { Text("Peso: ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            val edat = Calendar.getInstance().get(Calendar.YEAR) - any.toInt()
            val altura = altura.toFloat()
            val peso = peso.toFloat()

            val imc = if (altura > 0) peso / (altura * altura) else 0f
            val imcText = when {
                imc < 18.5 -> "Peso Insuficiente"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..49.9 -> "Sobrepeso"
                else -> "Obesidad"
            }
            resultado = "Nombre: $nombre\nEdat: $edat\nIMC: ${"%.2f".format(imc)}\nCategoria: $imcText"
            showResult = true
        }) {
            Text(text = "Calcular IMC")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (showResult) {
            Text(resultado, fontWeight = FontWeight.Bold, fontSize = 25.sp)
        }
    }
}

