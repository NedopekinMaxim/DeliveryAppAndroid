package com.example.deliveryappandroid.screens.history

import com.example.deliveryappandroid.api.model.responses.DishResponse


data class orderItem(
    val count: String,
    val address: String,
    val data: String,
    val price: String
)

val historyList: MutableList<orderItem> = mutableListOf<orderItem>()

var pubAdress: String = ""
