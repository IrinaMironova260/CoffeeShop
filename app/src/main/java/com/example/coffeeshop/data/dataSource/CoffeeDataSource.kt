package com.example.coffeeshop.data.dataSource

import androidx.lifecycle.LiveData
import com.example.coffeeshop.data.models.CoffeeModel

interface CoffeeDataSource {
    fun insert(coffeeModel: CoffeeModel)
    fun loadCoffee(): LiveData<List<CoffeeModel>>
    suspend fun clear()
}