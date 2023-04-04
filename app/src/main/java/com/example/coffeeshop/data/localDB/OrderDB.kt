package com.example.coffeeshop.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeshop.data.models.OrderLocalModel


@Database(entities = [OrderLocalModel::class], version = 1)
abstract class OrderDB: RoomDatabase()  {
    abstract val orderLocalDao: OrderLocalDao

}
