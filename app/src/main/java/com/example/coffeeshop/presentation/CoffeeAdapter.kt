package com.example.coffeeshop.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.data.models.CoffeeModel
import com.example.coffeeshop.databinding.CoffeeItemBinding
import com.squareup.picasso.Picasso

class CoffeeAdapter(
    private val addToCard: (CoffeeModel) -> Unit,
    private val removeFromCard: (CoffeeModel) -> Unit,
    private val loadCoffeeToCardFromCardProduct
    : (Int, AppCompatImageButton, AppCompatImageButton) -> Unit
) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeHolder>() {

    private val coffee = ArrayList<CoffeeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeHolder {
        val binding: CoffeeItemBinding = CoffeeItemBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return CoffeeHolder(binding)
    }

    override fun getItemCount(): Int {
        return coffee.size
    }

    override fun onBindViewHolder(holder: CoffeeHolder, position: Int) {
        holder.bind(coffee[position], addToCard, removeFromCard, loadCoffeeToCardFromCardProduct)
    }

    fun setList(coffeeList: List<CoffeeModel>) {
        coffee.clear()
        coffee.addAll(coffeeList)
    }

    class CoffeeHolder(val binding: CoffeeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            coffeeModel: CoffeeModel,
            addToCard: (CoffeeModel) -> Unit,
            removeFromCard: (CoffeeModel) -> Unit,
            loadCoffeeToCardFromCardProduct: (Int, AppCompatImageButton, AppCompatImageButton) -> Unit
        ) {
            val getImage = coffeeModel.image

            Picasso.get().load(getImage).into(binding.imageCoffee)
            binding.nameCoffee.text = coffeeModel.name
            binding.descriptionCoffee.text = coffeeModel.description
            binding.priceCoffee.text = coffeeModel.price

            binding?.addToBasket?.setOnClickListener(View.OnClickListener {
                addToCard(coffeeModel)
            })


            binding?.removeFromBasket?.setOnClickListener(View.OnClickListener {
                removeFromCard(coffeeModel)
            })
            loadCoffeeToCardFromCardProduct(coffeeModel.id, binding.addToBasket, binding.removeFromBasket)

        }
    }

}