package com.example.coffeeshop.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeshop.data.models.CoffeeModel

@Database(entities = [CoffeeModel::class], version = 1)

abstract class CoffeeDB: RoomDatabase() {
    abstract val coffeeDao: CoffeeDao

}