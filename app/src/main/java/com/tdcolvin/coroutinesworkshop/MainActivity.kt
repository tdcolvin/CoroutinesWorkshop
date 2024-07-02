package com.tdcolvin.coroutinesworkshop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.tdcolvin.coroutinesworkshop.ui.theme.CoroutinesWorkshopTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesWorkshopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowPINScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowPINScreen(modifier: Modifier = Modifier) {
    var showPin by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Button(
            onClick = {
            }
        ) {
            Text("Show PIN")
        }

        if (showPin) {
            Text(
                text = "Your PIN is 1248",
                fontSize = 40.sp
            )

            WarningLight()
        }
    }
}

@Composable
fun WarningLight() {
    var flashState by remember { mutableStateOf(true) }

    Column {
        Text(
            text = "WARNING:",
            modifier = Modifier.background(if (flashState) Color.Red else Color.Transparent),
            color = if (flashState) Color.White else Color.Black
        )
        Text("Do not share your PIN with anyone")
    }
}