package com.example.gautam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gautam.composable.CountIndicatorCircle
import com.example.gautam.composable.score
import com.example.gautam.composable.swiftPlaces
import com.example.gautam.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GautamTheme {
                swiftPlaces()
                // A surface container using the 'background' color from the theme
                /*Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CountIndicatorCircle(score(20))
                }*/
            }
        }
    }
}

/*
[16:38] Vikas

0-30% - Red: #FF3B30 - Low
30-50% - Orange: #FF9F0A - Moderate
50-80% - Yellow: #FFCF31 - Moderate
80- 100% - Green: #32D74B - High


 */


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GautamTheme {
        Greeting("Android")
    }
}