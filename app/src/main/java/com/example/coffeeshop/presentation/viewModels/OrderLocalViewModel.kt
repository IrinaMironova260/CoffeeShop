package com.example.coffeeshop.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.models.OrderLocalModel
import com.example.coffeeshop.domain.useCase.OrderLocalUseCase
import kotlinx.coroutines.launch

class OrderLocalViewModel(private val orderLocalUseCase: OrderLocalUseCase): ViewModel()  {

    fun startInsert(
        nameUser:String,
        phoneUser:String,
        description:String,
        totalPrice:String) {
        insert(OrderLocalModel(0, nameUser, phoneUser,description, totalPrice))
    }

    private fun insert(orderLocalModel: OrderLocalModel) = viewModelScope.launch {
        orderLocalUseCase.insert(orderLocalModel)
    }
}