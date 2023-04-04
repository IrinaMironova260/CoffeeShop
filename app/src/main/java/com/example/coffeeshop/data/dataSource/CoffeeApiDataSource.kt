package com.example.coffeeshop.data.dataSource

import android.content.Context

interface CoffeeApiDataSource {
    fun startMigration (context: Context)
}