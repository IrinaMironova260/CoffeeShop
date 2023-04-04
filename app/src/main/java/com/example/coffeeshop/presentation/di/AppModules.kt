package com.example.coffeeshop.presentation.di

import androidx.room.Room
import com.example.coffeeshop.data.dataSource.CoffeeApiDataSource
import com.example.coffeeshop.data.dataSource.CoffeeDataSource
import com.example.coffeeshop.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import com.example.coffeeshop.data.dataSourceIMPL.CoffeeDataSourceIMPL
import com.example.coffeeshop.data.localDB.CardDataBase
import com.example.coffeeshop.data.localDB.CoffeeDB
import com.example.coffeeshop.data.localDB.OrderDB
import com.example.coffeeshop.data.repository.CardRepository
import com.example.coffeeshop.data.repository.CoffeeRepository
import com.example.coffeeshop.data.repository.OrderLocalRepisitory
import com.example.coffeeshop.domain.repository.CardCall
import com.example.coffeeshop.domain.repository.CoffeeCall
import com.example.coffeeshop.domain.repository.OrderLocalCall
import com.example.coffeeshop.domain.useCase.CardUseCase
import com.example.coffeeshop.domain.useCase.CoffeeUseCase
import com.example.coffeeshop.domain.useCase.OrderLocalUseCase
import com.example.coffeeshop.presentation.viewModels.CardViewModel
import com.example.coffeeshop.presentation.viewModels.CoffeeViewModel
import com.example.coffeeshop.presentation.viewModels.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val coffee = module{

    single {
        Room.databaseBuilder(androidContext(), CoffeeDB ::class.java,
        "coffeeDB").build()
    }

    single { get<CoffeeDB>().coffeeDao }

    single<CoffeeDataSource> {
        CoffeeDataSourceIMPL(
            get()
        )
    }

    single<CoffeeApiDataSource> {
        CoffeeApiDataSourceIMPL(
            get()
        )
    }

    single<CoffeeCall> { CoffeeRepository(get(),get()) }
    single { CoffeeUseCase(get()) }
    viewModel { CoffeeViewModel(get()) }
}

val card = module{

    single {
        Room.databaseBuilder(androidContext(), CardDataBase ::class.java,
            "cardDB").build()
    }

    single { get<CardDataBase>().cardDao }

    single<CardCall> { CardRepository(get()) }
    single { CardUseCase(get()) }
    viewModel { CardViewModel(get()) }
}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), OrderDB ::class.java,
            "orderDB").build()
    }

    single { get<OrderDB>().orderLocalDao }

    single<OrderLocalCall> { OrderLocalRepisitory(get()) }
    single { OrderLocalUseCase(get()) }
    viewModel { OrderLocalViewModel(get()) }
}