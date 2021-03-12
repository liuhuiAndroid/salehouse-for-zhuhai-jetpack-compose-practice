package com.fizz.salehouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
                val scrollState = rememberScrollState()
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        HomeBanner(modifier)
                        HomeMenu(modifier)
                        Divider(color = Color(0xFFF3F6F8), thickness = 10.dp)
                        RecentlyViewed(modifier)
                        Divider(color = Color(0xFFF3F6F8), thickness = 10.dp)
                        Ads(modifier)
                        Divider(color = Color(0xFFF3F6F8), thickness = 10.dp)
                        ListTitle(modifier)
                        ListContent(modifier)
                        BottomButton(modifier)
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
        val modifierChild = Modifier.weight(1f)
        HomeMenuItem(modifierChild)
        HomeMenuItem(modifierChild)
        HomeMenuItem(modifierChild)
        HomeMenuItem(modifierChild)
        HomeMenuItem(modifierChild)
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
        val modifierChild = Modifier.weight(1f)
        Row {
            Image(
                modifier = modifierChild,
                painter = painterResource(R.drawable.home_ad1),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Divider(modifier = Modifier.width(7.dp), color = Color.White)
            Image(
                modifier = modifierChild,
                painter = painterResource(R.drawable.home_ad2),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
        }
        Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
            Image(
                modifier = modifierChild,
                painter = painterResource(R.drawable.home_ad_small_1),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Divider(modifier = Modifier.width(10.dp), color = Color.White)
            Image(
                modifier = modifierChild,
                painter = painterResource(R.drawable.home_ad_small_2),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Divider(modifier = Modifier.width(10.dp), color = Color.White)
            Image(
                modifier = modifierChild,
                painter = painterResource(R.drawable.home_ad_small_3),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
        }
    }
}

@Composable
fun ListTitle(modifier: Modifier) {
    Text(
        text = "推荐新房",
        modifier = modifier.padding(top = 18.dp),
        color = Color(0xFF333333),
        fontSize = 17.sp,
        style = typography.subtitle2
    )
}

@Composable
fun ListContent(modifier: Modifier) {
    ListItem(modifier)
    ListItem(modifier)
    ListItem(modifier)
    ListItem(modifier)
}

@Composable
fun BottomButton(modifier: Modifier) {
    Button(
        onClick = {

        },
        modifier = modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(45.dp),
        border = BorderStroke(
            width = 1.dp, brush = Brush.linearGradient(
                0.0f to Color(0xFFFF2D19),
                1.0f to Color(0xFFFF2D19),
                start = Offset(0.0f, 50.0f),
                end = Offset(0.0f, 100.0f)
            )
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.White,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Gray
        )
    ) {
        Text(
            text = "查看全部新房",
            color = Color(0xFFFF2D19),
            fontSize = 17.sp,
            style = typography.button
        )
    }
}

@Composable
fun ListItem(modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painterResource(R.drawable.home_list_house_pic),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 50.dp)
                .width(120.dp)
                .height(90.dp),
        )
        Column(modifier = Modifier.padding(top = 16.dp, start = 10.dp)) {
            Text(
                text = "万科星城",
                color = Color(0xFF333333),
                fontSize = 16.sp,
                style = typography.subtitle2
            )
            Text(
                text = "30-56m",
                color = Color(0xFF666666),
                fontSize = 12.sp,
                style = typography.subtitle2
            )
            Text(
                text = "宝安区-沙井片区",
                color = Color(0xFF666666),
                fontSize = 12.sp,
                style = typography.subtitle2
            )
        }
    }
    Divider(color = Color(0xFFEEEEEE), thickness = 1.dp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SalehouseTheme {
        Ads(Modifier)
    }
}