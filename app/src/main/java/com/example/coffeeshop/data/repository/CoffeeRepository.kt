package com.example.coffeeshop.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.coffeeshop.data.dataSource.CoffeeApiDataSource
import com.example.coffeeshop.data.dataSource.CoffeeDataSource
import com.example.coffeeshop.data.models.CoffeeModel
import com.example.coffeeshop.domain.repository.CoffeeCall

class CoffeeRepository (private val coffeeApiDataSource: CoffeeApiDataSource,
                        private val coffeeDataSource: CoffeeDataSource
): CoffeeCall {

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return coffeeDataSource.loadCoffee()    }


    override suspend fun startMigration(context: Context) {
        coffeeDataSource.clear()
        coffeeApiDataSource.startMigration(context)
    }

}