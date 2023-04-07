package com.example.coffeeshop.domain.useCase


import android.content.Context
import com.example.coffeeshop.domain.repository.OrderApiCall

class OrderApiUseCase(private var orderApiCall: OrderApiCall) {

    suspend fun insert (context: Context, name:String, phone:String, description:String, priceOrder:String) {
        orderApiCall.insert(context, name, phone, description, priceOrder)
    }
}