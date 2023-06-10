package com.example.composeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.basics.CheckBoxListCompleted
import com.example.composeplayground.basics.CheckInfo
import com.example.composeplayground.basics.MyBadgeBox
import com.example.composeplayground.basics.MyCard
import com.example.composeplayground.basics.MyCheckBoxWithText
import com.example.composeplayground.basics.MyAlertDialog
import com.example.composeplayground.basics.MyConfirmationDialog
import com.example.composeplayground.basics.MyCustomDialog
import com.example.composeplayground.basics.MyDropDownMenu
import com.example.composeplayground.basics.MyImageAdvance
import com.example.composeplayground.basics.MyProgressBarAdvance
import com.example.composeplayground.basics.MyRadioListButtons
import com.example.composeplayground.basics.MyRangeSlider
import com.example.composeplayground.basics.MySimpleCustomDialog
import com.example.composeplayground.basics.MyTextField
import com.example.composeplayground.basics.SimpleRecyclerView
import com.example.composeplayground.basics.SuperHeroView
import com.example.composeplayground.basics.SuperHeroWithSpecialControlView
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
            //DropDownMenuPreview()
            //SliderPreview()
            //AlertDialogsPreview()
            //CustomSimpleDialogsPreview()
            //CustomDialogsPreview()
            //ConfirmationDialogsPreview()
            RecyclerViewPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecyclerViewPreview() {
    //SimpleRecyclerView()
    //SuperHeroView()
    SuperHeroWithSpecialControlView()
}

@Composable
fun ConfirmationDialogsPreview() {
    var show by remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Show Toast message")
        }
    }
    MyConfirmationDialog(show = show, onDismiss = { show = false })
}

//@Preview(showBackground = true)
@Composable
fun CustomDialogsPreview() {
    var show by remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Show Toast message")
        }
    }
    MyCustomDialog(show = show, onDismiss = { show = false })

}


//@Preview(showBackground = true)
@Composable
fun CustomSimpleDialogsPreview() {
    var show by remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Show Toast message")
        }
    }
    MySimpleCustomDialog(show = show, onDismiss = { show = false })
}

//@Preview(showBackground = true)
@Composable
fun AlertDialogsPreview() {
    val context = LocalContext.current
    var show by remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Show Toast message")
        }
    }
    MyAlertDialog(
        show = show,
        onDismiss = { show = false },
        onConfirm = { Toast.makeText(context, "Confirmation Success", Toast.LENGTH_SHORT).show() }
    )
}

//@Preview(showBackground = true)
@Composable
fun SliderPreview() {
    //BasicSlider()
    //AdvanceSlider()
    MyRangeSlider()
}

//@Preview(showBackground = true)
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

        var myText by remember { mutableStateOf("Aris") }
        MyTextField(myText) { myText = it }
    }
}
