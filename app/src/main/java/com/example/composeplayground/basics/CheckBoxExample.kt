package com.example.composeplayground.basics

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

data class CheckInfo(
    val title: String,
    val isChecked: Boolean = false,
    val onChecked: (Boolean) -> Unit
)

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false)}

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state } )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Ejemplo 1")
    }
}


@Composable
fun getOptions(titles: List<String>) : List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            isChecked = status,
            onChecked = { newStatus -> status = newStatus }
        )
    }
}

@Composable
fun CheckBoxListCompleted(checkInfo: CheckInfo) {
    ComposePlaygroundTheme {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkInfo.isChecked,
                onCheckedChange = { checkInfo.onChecked(!checkInfo.isChecked) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = checkInfo.title
            )
        }
    }
}

