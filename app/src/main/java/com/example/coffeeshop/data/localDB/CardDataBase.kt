package com.example.coffeeshop.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeshop.data.models.CardModel

@Database(entities =[CardModel::class], version = 1)
abstract class CardDataBase :RoomDatabase() {
    abstract val cardDao:CardDao
}