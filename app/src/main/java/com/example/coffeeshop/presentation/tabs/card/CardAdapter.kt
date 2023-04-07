package com.example.coffeeshop.presentation.tabs.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.data.models.CardModel
import com.example.coffeeshop.databinding.CardItemBinding
import com.squareup.picasso.Picasso

class CardAdapter(
    private val deleteFromCard: (CardModel) -> Unit,
    private val lessCount: (CardModel) -> Unit,
    private val moreCount: (CardModel) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardHolder>() {

    private val productsFromCard = ArrayList<CardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding: CardItemBinding = CardItemBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsFromCard.size
    }


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(
            productsFromCard[position], deleteFromCard, moreCount, lessCount)
    }

    fun setList(cardList: List<CardModel>) {
        productsFromCard.clear()
        productsFromCard.addAll(cardList)
    }

    class CardHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            cardModel: CardModel,
            deleteFromCard: (CardModel) -> Unit,
            moreCount: (CardModel) -> Unit,
            lessCount: (CardModel) -> Unit
        ) {
            val getImage = cardModel.image
            Picasso.get().load(getImage).into(binding.imageProductCard)
            binding.nameProductCard.text = cardModel.name
            binding.countProductBasket.text = cardModel.count
            binding.priceProductCard.text = cardModel.price
            binding.totalPriceProductCard.text = cardModel.totalPrice

            binding.removeFromCardProductCard.setOnClickListener(View.OnClickListener {
                deleteFromCard(cardModel)
            })

            binding.moreProductBasket.setOnClickListener(View.OnClickListener {
                moreCount(cardModel)
            })

            binding.lessProductBasket.setOnClickListener(View.OnClickListener {
                lessCount(cardModel)

            })
        }
    }
}