package com.example.coffeeshop.data.api

import com.example.coffeeshop.data.models.CoffeeApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadCoffee.php")
    fun loadCoffeeApi(): Call<ArrayList<CoffeeApiModel>>
}