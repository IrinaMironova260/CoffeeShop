package com.example.coffeeshop.presentation.di

import androidx.room.Room
import com.example.coffeeshop.data.dataSource.CoffeeApiDataSource
import com.example.coffeeshop.data.dataSource.CoffeeDataSource
import com.example.coffeeshop.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import com.example.coffeeshop.data.dataSourceIMPL.CoffeeDataSourceIMPL
import com.example.coffeeshop.data.localDB.DataBaseCoffee
import com.example.coffeeshop.data.repository.CardRepository
import com.example.coffeeshop.data.repository.CoffeeRepository
import com.example.coffeeshop.data.repository.OrderApiRepository
import com.example.coffeeshop.data.repository.OrderLocalRepisitory
import com.example.coffeeshop.domain.repository.CardCall
import com.example.coffeeshop.domain.repository.CoffeeCall
import com.example.coffeeshop.domain.repository.OrderApiCall
import com.example.coffeeshop.domain.repository.OrderLocalCall
import com.example.coffeeshop.domain.useCase.CardUseCase
import com.example.coffeeshop.domain.useCase.CoffeeUseCase
import com.example.coffeeshop.domain.useCase.OrderApiUseCase
import com.example.coffeeshop.domain.useCase.OrderLocalUseCase
import com.example.coffeeshop.presentation.viewModels.CardViewModel
import com.example.coffeeshop.presentation.viewModels.CoffeeViewModel
import com.example.coffeeshop.presentation.viewModels.OrderApiViewModel
import com.example.coffeeshop.presentation.viewModels.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val coffee = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee ::class.java,
        "coDB").build()
    }

    single { get<DataBaseCoffee >().coffeeDao }

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
        Room.databaseBuilder(androidContext(), DataBaseCoffee  ::class.java,
            "cDB").build()
    }
    single { get<DataBaseCoffee >().cardDao }

    single<CardCall> { CardRepository(get()) }
    single { CardUseCase(get()) }
    viewModel { CardViewModel(get()) }
}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee ::class.java,
            "oDB").build()
    }
    single { get<DataBaseCoffee >().orderLocalDao }

    single<OrderLocalCall> { OrderLocalRepisitory(get()) }
    single { OrderLocalUseCase(get()) }
    viewModel { OrderLocalViewModel(get()) }
}

val orderApi = module{

    single<OrderApiCall> { OrderApiRepository() }
    single { OrderApiUseCase(get()) }
    viewModel { OrderApiViewModel(get()) }
}