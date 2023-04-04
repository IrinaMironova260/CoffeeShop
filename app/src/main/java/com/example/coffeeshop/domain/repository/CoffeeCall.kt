package com.example.coffeeshop.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.coffeeshop.data.models.CoffeeModel

interface CoffeeCall {

    fun loadCoffee(): LiveData<List<CoffeeModel>>
    suspend fun startMigration(context: Context)
}