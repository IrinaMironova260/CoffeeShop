package com.example.coffeeshop.domain.repository

import com.example.coffeeshop.data.models.OrderLocalModel

interface OrderLocalCall {
   suspend fun insert(orderLocalModel: OrderLocalModel)
}