package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(){
    //Weight modifier
    // - Helps divide sections of the screen proportionally based on weight given to each child
    // - Examples:
    //     - 1f and 1f ---> means split evenly (1 + 1 = 2, so 1/2 equals 50%)
    //     - 1f and 2f ---> means one side gets 1/3 and other gets 2/3 (1 + 2 = 3, so 1/3 and 2/3)
    //     - 10f and 90f --> means one side gets 1/10 and other gets 9/10 (10 + 90 = 100, so 10/100 and 90/100)
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)){
            ComposableInfoCard("title 1", "body 1", Green, Modifier.weight(1f))
            ComposableInfoCard("title 2", "body 2", Yellow, Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)){
            ComposableInfoCard("title 3", "body 3", Cyan, Modifier.weight(1f))
            ComposableInfoCard("title 4", "body 4", LightGray, Modifier.weight(1f))
        }
    }
}

@Composable
fun ComposableInfoCard(
    title: String,
    body: String,
    backgroundColor: Color,
    modifier: Modifier){
    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(body)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}