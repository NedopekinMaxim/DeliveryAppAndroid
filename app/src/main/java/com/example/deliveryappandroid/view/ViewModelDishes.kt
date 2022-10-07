package com.example.deliveryappandroid.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.api.retrofit.RetrofitClient
import com.example.deliveryappandroid.api.servieces.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelDishes : ViewModel() {
    val retIn = RetrofitClient.getRetrofitInstance().create(RetrofitService::class.java)
    private var _todoItems = MutableLiveData(listOf<DishResponse>())
    val todoItems: LiveData<List<DishResponse>> = _todoItems
    fun getList() {
        retIn.getDish().enqueue(object : Callback<List<DishResponse>> {
            override fun onResponse(
                call: Call<List<DishResponse>>,
                response: Response<List<DishResponse>>
            ) {
                response.body()?.let { it ->
                    _todoItems.value = it.toMutableList()
                }
            }

            override fun onFailure(call: Call<List<DishResponse>>, t: Throwable) {
                t.printStackTrace()
                println("request wrong")
            }
        })
    }
}