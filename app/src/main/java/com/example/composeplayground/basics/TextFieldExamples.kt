package com.example.composeplayground.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyTextFieldOutLined() {
    var myText by remember { mutableStateOf("Aris") }
    OutlinedTextField(
        value = myText,
        onValueChange = {myText = it},
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holita") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = { myText = if (it.contains("a")) it.replace("a","") else it },
        label = { Text(text = "Introduce tu nombre") }
    )
}

@Composable
fun MyTextField(text: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { onValueChanged(it) }
    )
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Example 1")
        Text(text = "Example 2", color = Color.Blue)
        Text(text = "Example 3", fontWeight = FontWeight.ExtraBold)
        Text(text = "Example 4", fontWeight = FontWeight.Light)
        Text(text = "Example 5", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Example 6",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Example 7",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Example 8",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                )
            )
        )
        Text(text = "hola", fontSize = 25.sp)
    }
}
