package com.example.coffeapp.presentation.screens.cartscreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Product
import com.example.coffeapp.presentation.ui_components.cartscreen_components.CartScreenTopAppBar

@Preview
@Composable
fun CartScreen() {

    val products = listOf(

        Product(1, "Espresso", "Strong and rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Cappuccino", "With chocolate", 4.20, R.drawable.coffee_1)

        )

    Scaffold(
        topBar = { CartScreenTopAppBar() }
    ) { }

}