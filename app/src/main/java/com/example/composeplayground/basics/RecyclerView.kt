package com.example.composeplayground.basics

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R
import com.example.composeplayground.models.SuperHero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Aris", "Paco", "Donald", "Jaime" )
        LazyColumn {
            item { Text(text = "Primer item") }
            items(7) {
                Text(text = "posicion: $it")
            }
            items(myList) {
                Text(text = "Hola me llamo $it")
            }
        }
}

@Composable
fun SuperHeroWithSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column() {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, "On ${it.heroName} selected.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf { rvState.firstVisibleItemIndex > 0 }
        }

        if(showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un botón cool")
            }
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(context, "On ${it.heroName} selected.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(
    superHero: SuperHero,
    onItemSelected: (SuperHero) -> Unit
) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) }
    ) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.heroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superHero.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = superHero.realName, modifier = Modifier.align(Alignment.End).padding(8.dp), fontSize = 10.sp,)
        }
    }
}

fun getSuperHeroes() : List<SuperHero> {
    return listOf(
        SuperHero(heroName = "SpiderMan", realName = "Peter Parker", publisher = "Marvel", R.drawable.spiderman),
        SuperHero(heroName = "Wolverine", realName = "James Howlett", publisher = "Marvel", R.drawable.logan),
        SuperHero(heroName = "Batman", realName = "Bruce Wayne", publisher = "DC", R.drawable.batman),
        SuperHero(heroName = "Thor", realName = "Thor Odinson", publisher = "Marvel", R.drawable.thor),
        SuperHero(heroName = "Flash", realName = "Jay Garrick", publisher = "DC", R.drawable.flash),
        SuperHero(heroName = "Green Lantern", realName = "Alan Scott", publisher = "DC", R.drawable.green_lantern),
        SuperHero(heroName = "Wonder Woman", realName = "Princess Diana", publisher = "DC", R.drawable.wonder_woman)
    )
}

