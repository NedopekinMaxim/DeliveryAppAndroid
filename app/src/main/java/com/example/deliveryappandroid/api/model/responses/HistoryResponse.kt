package com.example.deliveryappandroid.api.model.responses

data class HistoryResponse(
    val address: String?,
    val date: String,
    val dishes: MutableList<DishesOrder>
)

data class DishesOrder(
    val dishId: String,
    var count: Int
)