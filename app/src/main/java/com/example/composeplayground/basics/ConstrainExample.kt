package com.example.composeplayground.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview
@Composable
fun ConstrainExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxYellow, boxBlue, boxMagenta) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxRed.top)
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
    }
}

//@Preview
@Composable
fun ConstrainExampleGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            }
        )
    }
}

@Preview
@Composable
fun ConstraintBarrier() {
    ConstraintLayout {
        val (boxRed, boxBlue, boxGreen) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxRed.top)
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(barrier)
            })
    }
}