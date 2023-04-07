package com.example.coffeeshop.domain.repository

import androidx.lifecycle.LiveData
import com.example.coffeeshop.data.models.OrderLocalModel

interface OrderLocalCall {
   suspend fun insert(orderLocalModel: OrderLocalModel)
   fun loadOrder(): LiveData<List<OrderLocalModel>>
}