package com.example.coffeeshop.data.repository


import androidx.lifecycle.LiveData
import com.example.coffeeshop.data.localDB.OrderLocalDao
import com.example.coffeeshop.data.models.OrderLocalModel
import com.example.coffeeshop.domain.repository.OrderLocalCall

class OrderLocalRepisitory (private val orderLocalDao: OrderLocalDao): OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)
    }
    override fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalDao.loadOrder()    }

}