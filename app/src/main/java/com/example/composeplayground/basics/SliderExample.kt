package com.example.composeplayground.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..10f,
            onValueChangeFinished = { completeValue = sliderPosition.toInt().toString() },
            steps = 9
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = currentRange.start.toUInt().toString())
        Text(text = currentRange.endInclusive.toUInt().toString())
    }
}