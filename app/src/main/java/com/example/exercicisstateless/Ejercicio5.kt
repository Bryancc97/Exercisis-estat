package com.example.exercicisstateless

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.platform.LocalContext

@Composable
fun ConversorUnidades() {
    var valor: String by remember { mutableStateOf("") }
    var unidadSeleccionada: String by remember { mutableStateOf("Pulgada a Centímetro") }
    var resultado: String by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val opciones = listOf(
        "Pulgada a Centímetro",
        "Yarda a Metro",
        "Milla a Kilómetro",
        "Centímetro a Pulgada",
        "Metro a Yarda",
        "Kilómetro a Milla"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Conversor de Unidades", fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(8.dp))

        TextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text("Valor a transformar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(8.dp))

        // DropdownMenu para seleccionar la unidad
        Button(onClick = { expanded = true }) {
            Text(text = unidadSeleccionada)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(onClick = {
                    unidadSeleccionada = opcion
                    expanded = false
                }) {
                    Text(text = opcion)
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            if (valor.isEmpty()) {
                Toast.makeText(context, "Se debe introducir un valor.", Toast.LENGTH_SHORT).show()
                return@Button
            }

            val valorDouble = valor.toDoubleOrNull()
            if (valorDouble == null) {
                Toast.makeText(context, "Se debe introducir un número válido.", Toast.LENGTH_SHORT).show()
                return@Button
            }

            resultado = when (unidadSeleccionada) {
                "Pulgada a Centímetro" -> (valorDouble * 2.54).toString()
                "Yarda a Metro" -> (valorDouble * 0.9144).toString()
                "Milla a Kilómetro" -> (valorDouble * 1.60934).toString()
                "Centímetro a Pulgada" -> (valorDouble / 2.54).toString()
                "Metro a Yarda" -> (valorDouble / 0.9144).toString()
                "Kilómetro a Milla" -> (valorDouble / 1.60934).toString()
                else -> ""
            }
        }) {
            Text(text = "Convertir")
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Resultado: $resultado", fontSize = 18.sp)
    }
}