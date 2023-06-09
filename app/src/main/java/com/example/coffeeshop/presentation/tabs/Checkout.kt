package com.example.coffeeshop.presentation.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.coffeeshop.data.models.CardModel
import com.example.coffeeshop.databinding.CheckoutBinding
import com.example.coffeeshop.presentation.viewModels.CardViewModel
import com.example.coffeeshop.presentation.viewModels.OrderApiViewModel
import com.example.coffeeshop.presentation.viewModels.OrderLocalViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class Checkout : BottomSheetDialogFragment() {

    private var binding: CheckoutBinding? = null
    private val cardViewModel: CardViewModel by viewModel()
    private val orderLocalViewModel: OrderLocalViewModel by viewModel()
    private val orderApiViewModel: OrderApiViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CheckoutBinding.inflate(inflater, container, false)

        binding?.submitCheckout?.setOnClickListener(View.OnClickListener {

            cardViewModel.loadCoffeeFromCard.observe(viewLifecycleOwner, Observer {

                val totalOrder:Int = it.sumOf<CardModel> { it.totalPrice.toInt() }
                val descriptionOrder = it.map { it.name + ": count - " + it.count + ", " +
                        "price - " + it.totalPrice + " $; " }.joinToString("")

                orderLocalViewModel.startInsert(
                    binding?.enterNameCheckout?.text.toString(),
                    binding?.enterPhoneCheckout?.text.toString(),
                    descriptionOrder,
                    totalOrder.toString()
                )

                orderApiViewModel.insert(
                    (context as Context),
                    binding?.enterNameCheckout?.text.toString(),
                    binding?.enterPhoneCheckout?.text.toString(),
                    descriptionOrder,
                    totalOrder.toString()
                )
                binding?.enterNameCheckout?.setText("")
                binding?.enterPhoneCheckout?.setText("")

                dismiss()
                cardViewModel.cleanCard()

            })
        })

        return binding?.root
    }


}