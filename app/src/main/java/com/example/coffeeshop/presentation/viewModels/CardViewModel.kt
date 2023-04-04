package com.example.coffeeshop.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.models.CardModel
import com.example.coffeeshop.domain.useCase.CardUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel (private val cardUseCase: CardUseCase): ViewModel() {

    fun startInsert(
        nameProduct:String,
        imageProduct:String,
        priceProduct:String,
        idProduct:String,
        countProduct:String) {
        insert(
            CardModel(0, nameProduct, imageProduct, priceProduct, idProduct, countProduct,
                (priceProduct.toInt()*countProduct.toInt()).toString())
        )
    }

    private fun insert(cardModel: CardModel) = viewModelScope.launch {
        cardUseCase.insert(cardModel)
    }

    val loadCoffeeFromCard = cardUseCase.loadCoffeeFromCard()


    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>> {
        return cardUseCase.loadCoffeeToCardFromCardProduct(idProduct)
    }

    fun updateProductToCard(cardModel: CardModel) = viewModelScope.launch{
        cardUseCase.updateProductToCard(cardModel)
    }


    fun deleteProductFromCard(idProduct:Int) = viewModelScope.launch{
        cardUseCase.deleteProductFromCard(idProduct)
    }

    fun deleteProductToCardFromCardProduct(idProduct:String) = viewModelScope.launch{
        cardUseCase.deleteProductToCardFromCardProduct(idProduct)
    }

    fun cleanCard() = viewModelScope.launch {
        cardUseCase.clear()
    }
}