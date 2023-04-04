package com.example.coffeeshop.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.coffeeshop.data.models.OrderLocalModel

@Dao
interface OrderLocalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderLocalModel: OrderLocalModel)
}