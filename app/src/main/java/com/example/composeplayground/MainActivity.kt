package com.example.composeplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TextFieldsPreview()
            ButtonsPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ComposePlaygroundTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Button(
                onClick = { Log.i("Aris", "Esto es un ejemplo") },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.Blue
                ),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "MyButton")
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    ComposePlaygroundTheme {
        //ConstrainExample()
        //MyStateExample()
        //MyText()
        //MyTextFieldAdvance()
        //MyTextFieldOutLined()

        var myText by remember { mutableStateOf("Aris")}
        MyTextField(myText) { myText = it }
    }
}

