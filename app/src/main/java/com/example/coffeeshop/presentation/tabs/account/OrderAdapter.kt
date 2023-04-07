package com.example.coffeeshop.presentation.tabs.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.data.models.OrderLocalModel
import com.example.coffeeshop.databinding.OrderItemBinding

class CheckoutAdaptor : RecyclerView.Adapter<CheckoutAdaptor.OrderHolder>() {

    private val orders = ArrayList<OrderLocalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val binding: OrderItemBinding = OrderItemBinding .inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OrderHolder(binding)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.bind(orders[position])
    }

    fun setList(orderList: List<OrderLocalModel>) {
        orders.clear()
        orders.addAll(orderList)
    }

    class OrderHolder(val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            orderLocalModel: OrderLocalModel
        ) {
            binding.nameUserCheckout.text = orderLocalModel.nameUser
            binding.phoneUserCheckout.text = orderLocalModel.phoneUser
            binding.descriptionCheckout.text = orderLocalModel.description
            binding.totalPriceCheckout.text = orderLocalModel.totalPrice
             }
    }

}