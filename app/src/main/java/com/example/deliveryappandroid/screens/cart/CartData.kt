package com.example.deliveryappandroid.screens.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.deliveryappandroid.api.model.responses.DishResponse


val cartList: MutableList<DishResponse> = mutableListOf<DishResponse>()

fun getPrice(cartList: MutableList<DishResponse>): Int {
    var price = 0
    return if (cartList.isNotEmpty()) {
        for (i in cartList) {
            price += i.price.toInt()
        }
        price
    } else {
        0
    }
}




