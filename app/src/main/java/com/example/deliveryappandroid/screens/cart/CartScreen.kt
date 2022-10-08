package com.example.deliveryappandroid.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.screens.cart.cartList
import com.example.deliveryappandroid.screens.tabs.Dish
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.TittleColor

@Composable
fun CartScreen() {

    var address by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier.height(60.dp),
            backgroundColor = BackgroundColor,
            contentColor = Color.White
        ) {

            Text("Корзина", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    placeholder = {
                        Text(
                            text = "Ваш адрес доставки",
                            color = TittleColor,
                            fontWeight = FontWeight.Light
                        )
                    },
                    leadingIcon = { Icons.Default.Navigation },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                    )
                )


            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            itemsIndexed(
                cartList
            ) { _, item ->
                Dish(item = item)

            }

        }
    }
}