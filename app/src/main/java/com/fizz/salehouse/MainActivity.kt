package com.fizz.salehouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fizz.salehouse.ui.theme.SalehouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SalehouseTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column() {
                        val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        HomeBanner(modifier)
                        HomeMenu(modifier)
                        Divider(color = Color(0xFFF3F6F8), thickness = 10.dp)
                        RecentlyViewed(modifier)
                        Divider(color = Color(0xFFF3F6F8), thickness = 10.dp)
                        Ads(modifier)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeBanner(modifier: Modifier) {
    Image(
        modifier = modifier
            .padding(top = 10.dp)
            .heightIn(max = 120.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp)),
        painter = painterResource(R.drawable.home_banner),
        contentScale = ContentScale.Fit,
        contentDescription = null
    )
}


@Composable
fun HomeMenu(modifier: Modifier) {
    Row(
        modifier = modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var modifier = Modifier.weight(1f)
        HomeMenuItem(modifier)
        HomeMenuItem(modifier)
        HomeMenuItem(modifier)
        HomeMenuItem(modifier)
        HomeMenuItem(modifier)
    }
}

@Composable
fun HomeMenuItem(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(44.dp)
                .height(44.dp),
            painter = painterResource(R.drawable.home_menu_all),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
        Text(
            text = "全部楼盘",
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF666666),
            fontSize = 13.sp
        )
    }
}

@Composable
fun RecentlyViewed(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            "\"A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
            style = typography.h6, maxLines = 2, overflow = TextOverflow.Ellipsis
        )
        Text("Davenport, California", style = typography.body2)
        Text("December 2018", style = typography.body2)
    }
}

@Composable
fun Ads(modifier: Modifier) {
    Column(modifier = modifier.padding(top = 15.dp)) {
        var modifier = Modifier.weight(1f)
        Row {
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.home_ad1),
                contentDescription = null
            )
            Divider(modifier = Modifier.width(7.dp), color = Color.White)
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.home_ad2),
                contentDescription = null
            )
        }
        Row(modifier = Modifier.padding(top = 10.dp)) {
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.home_ad_small_1),
                contentDescription = null
            )
            Divider(modifier = Modifier.width(10.dp), color = Color.White)
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.home_ad_small_2),
                contentDescription = null
            )
            Divider(modifier = Modifier.width(10.dp), color = Color.White)
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.home_ad_small_3),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SalehouseTheme {
        Ads(Modifier)
    }
}