package com.example.composeplayground.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton() {
    RadioButton(
        selected = true,
        onClick = {  },
        enabled = true,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            unselectedColor = Color.Red,
            disabledColor = Color.Green
        )
    )
}

@Composable
fun MyRadioListButtons(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Option 1", onClick = { onItemSelected("Option 1") })
            Text(text = "Option 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Option 2", onClick = { onItemSelected("Option 2") })
            Text(text = "Option 2")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Option 3", onClick = { onItemSelected("Option 3") })
            Text(text = "Option 3")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Option 4", onClick = { onItemSelected("Option 4") })
            Text(text = "Option 4")
        }
    }
}

