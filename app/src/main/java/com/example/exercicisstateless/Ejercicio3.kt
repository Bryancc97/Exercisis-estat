package com.example.exercicisstateless

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
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
fun numerosecreto(){
    var numero: String by remember { mutableStateOf("") }
    var numerorandom: Int by remember { mutableIntStateOf(Random.nextInt(0, 101)) }
    var mensaje: String by remember { mutableStateOf("") }
    Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Advina el numero entre 0 y 100", fontSize = 20.sp)
        TextField(
        value = numero,
        onValueChange = { numero = it },
        label = { Text("Ingrese un número") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

    }

}