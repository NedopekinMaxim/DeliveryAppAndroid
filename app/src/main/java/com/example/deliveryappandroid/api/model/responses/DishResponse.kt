package com.example.deliveryappandroid.api.model.responses

data class DishResponse(
    val dishId: String,
    val category: String,
    val nameDish: String,
    val price: String,
    val icon: String,
    val version: String
)