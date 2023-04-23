package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.basics.CheckBoxListCompleted
import com.example.composeplayground.basics.CheckInfo
import com.example.composeplayground.basics.MyBadgeBox
import com.example.composeplayground.basics.MyCard
import com.example.composeplayground.basics.MyCheckBoxWithText
import com.example.composeplayground.basics.MyImageAdvance
import com.example.composeplayground.basics.MyProgressBarAdvance
import com.example.composeplayground.basics.MyRadioButton
import com.example.composeplayground.basics.MyRadioListButtons
import com.example.composeplayground.basics.MyTextField
import com.example.composeplayground.basics.getOptions
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TextFieldsPreview()
            //ButtonsPreview()
            //CheckBoxListPreview()
            //CheckBoxListCompletePreview()
            //RadioButtonPreview()
            //CardPreview()
            // BadgeBoxPreview()
            DropDownMenuPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownMenuPreview() {
    MyDropDownMenu()
}

//@Preview(showBackground = true)
@Composable
fun BadgeBoxPreview() {
    MyBadgeBox()
}

//@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MyCard()
}

//@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    //MyRadioButton()
    var selected by remember { mutableStateOf("Option 1") }
    Column {
        MyRadioListButtons(selected) { selected = it }
    }
}

//@Preview(showBackground = true)
@Composable
fun CheckBoxListCompletePreview() {
    val options = getOptions(titles = listOf("Aris", "Example", "Pikachu", "Taurus"))
    Column {
        options.forEach {
            CheckBoxListCompleted(checkInfo = it)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun CheckBoxListPreview() {
    ComposePlaygroundTheme {
        var status by rememberSaveable { mutableStateOf(false) }
        val checkInfo = CheckInfo(
            title = "Ejemplo 1",
            isChecked = status,
            onChecked = { newStatus -> status = newStatus }
        )
        MyCheckBoxWithText()
    }
}

//@Preview(showBackground = true)
@Composable
fun ProgressBarPreview() {
    ComposePlaygroundTheme {
        MyProgressBarAdvance()
    }
}

//@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ComposePlaygroundTheme {
       MyImageAdvance()
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
