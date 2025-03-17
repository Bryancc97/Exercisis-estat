package com.example.exercicisstateless

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp

@Composable
fun Calcular() {
    var propina: String by remember { mutableStateOf("") }
    var pMenu: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var resultado: String by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = pMenu, onValueChange = { pMenu = it }, label = { Text("Precio Menu: ") })
        TextField(
            value = propina,
            onValueChange = { propina = it },
            label = { Text("Propina %: ") })
        Button(onClick = {
            val pMenuValue = pMenu.toFloat()
            val propinaValue = propina.toFloat()
            resultado = (pMenuValue * propinaValue / 100).toString()
            showText = true
        }) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        if (showText) {
            Text("Propina: $resultado", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }

}
