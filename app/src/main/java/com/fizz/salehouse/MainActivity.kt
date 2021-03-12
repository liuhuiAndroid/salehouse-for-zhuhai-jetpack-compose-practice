package com.fizz.salehouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fizz.salehouse.ui.theme.SalehouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SalehouseTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            modifier = Modifier
                .heightIn(max = 120.dp)
                .fillMaxWidth(),
            painter = painterResource(R.drawable.home_banner),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            "\"A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
            style = typography.h6, maxLines = 2, overflow = TextOverflow.Ellipsis
        )
        Text("Davenport, California", style = typography.body2)
        Text("December 2018", style = typography.body2)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SalehouseTheme {
        Greeting()
    }
}