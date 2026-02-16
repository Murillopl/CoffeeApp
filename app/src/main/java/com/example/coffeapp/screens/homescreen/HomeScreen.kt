package com.example.coffeapp.screens.homescreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.screens.ui_components.MyBottomNavBar


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { MyBottomNavBar() }
    ) { }
}