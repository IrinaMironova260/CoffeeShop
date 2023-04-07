package com.example.coffeeshop.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeshop.data.models.CardModel
import com.example.coffeeshop.data.models.CoffeeModel
import com.example.coffeeshop.data.models.OrderLocalModel

@Database(entities = [CoffeeModel::class, CardModel::class, OrderLocalModel::class], version = 1)
abstract class DataBaseCoffee: RoomDatabase(){
    abstract val coffeeDao: CoffeeDao
    abstract val cardDao:CardDao
    abstract val orderLocalDao: OrderLocalDao
}