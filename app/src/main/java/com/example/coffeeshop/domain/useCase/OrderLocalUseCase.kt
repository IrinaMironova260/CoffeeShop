package com.example.coffeeshop.domain.useCase

import com.example.coffeeshop.data.models.OrderLocalModel
import com.example.coffeeshop.domain.repository.OrderLocalCall

class OrderLocalUseCase(private val orderLocalCall: OrderLocalCall) {

    suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalCall.insert(orderLocalModel)
    }

}