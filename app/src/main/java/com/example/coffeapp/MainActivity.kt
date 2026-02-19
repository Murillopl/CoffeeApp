package com.example.coffeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coffeapp.presentation.navigation.NavGraph
import com.example.coffeapp.presentation.theme.CoffeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeAppTheme {
                NavGraph()
            }
        }
    }
}
