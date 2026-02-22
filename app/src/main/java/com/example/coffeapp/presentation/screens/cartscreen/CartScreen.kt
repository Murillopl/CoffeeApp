package com.example.coffeapp.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Product
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.ui_components.cartscreen_components.CartItemCard
import com.example.coffeapp.presentation.ui_components.cartscreen_components.CartScreenTopAppBar
import com.example.coffeapp.presentation.ui_components.cartscreen_components.PaymentModeSelectionCard
import com.example.coffeapp.presentation.ui_components.homescreen_components.MyBottomNavBar

@Composable
fun CartScreen(navController: NavController) {

    val cartProducts = listOf(

        Product(1, "Espresso", "Strong and rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Cappuccino", "With chocolate", 4.20, R.drawable.coffee_1)

        )

    var amount by remember { mutableStateOf(0.0) }
    var deliveryFee by remember { mutableStateOf(1.0) }
    var totalAmount by remember { mutableStateOf(amount + deliveryFee) }


    Scaffold(
        topBar = { CartScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController, "Cart") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .padding(innerPadding)
        ) {

           item{

               Row() {

                   Text(
                       text = "Deliver",
                       fontSize = 30.sp,
                       fontWeight = FontWeight.Bold,
                       color = LightBrown

                   )
               }

               Spacer(modifier = Modifier.height(16.dp))

               cartProducts.forEach { product ->
                   CartItemCard(product = product)
               }

               Spacer(modifier = Modifier.height(20.dp))

               Text(
                   text = "Payment Summary",
                   style = MaterialTheme.typography.titleMedium.copy(
                       fontWeight = FontWeight.Bold,
                       fontSize = 20.sp
                   )
               )

               Spacer(modifier = Modifier.height(8.dp))

               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   Text(text = "Price", fontSize = 18.sp)
                   Text(text = "$ $amount", fontSize = 18.sp)
               }

               Spacer(modifier = Modifier.height(2.dp))

               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   Text(text = "Delivery Fee", fontSize = 18.sp)
                   Text(text = "$ $deliveryFee", fontSize = 18.sp)
               }

               Spacer(modifier = Modifier.height(16.dp))

               PaymentModeSelectionCard(totalAmount)

           }
        }
    }
}