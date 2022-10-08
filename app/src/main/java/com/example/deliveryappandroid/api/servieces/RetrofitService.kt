package com.example.deliveryappandroid.api.servieces

import com.example.deliveryappandroid.api.model.requests.LoginRequest
import com.example.deliveryappandroid.api.model.requests.OrderRequest
import com.example.deliveryappandroid.api.model.requests.RegisterRequest
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.api.model.responses.TokenResponse
import com.example.deliveryappandroid.api.model.responses.VersionResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    @Headers("Content-Type:application/json")
    @GET("./dishes?version=1.01")
    fun getDish(): Call<List<DishResponse>>

    @Headers("Content-Type:application/json")
    @GET("./dishes/version")
    fun getVersion(): Single<VersionResponse>

    @Headers("Content-Type:application/json")
    @GET("./histories")
    fun sendHistoryRequest(): Single<List<OrderRequest>>

    @Headers("Content-Type:application/json")
    @POST("./order")
    fun sendOrderRequest(@Body orderRequest: OrderRequest): Completable

    @Headers("Content-Type:application/json")
    @POST("./auth/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("./auth/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<ResponseBody>




}