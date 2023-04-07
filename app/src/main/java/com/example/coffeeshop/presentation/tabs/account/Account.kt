package com.example.coffeeshop.presentation.tabs.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.databinding.AccountBinding
import com.example.coffeeshop.presentation.viewModels.OrderLocalViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Account : Fragment() {

    private var binding: AccountBinding? = null
    private var orderAdapter: CheckoutAdaptor? = null
    private val orderLocalViewModel: OrderLocalViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AccountBinding.inflate(inflater, container, false)

        initRecyclerOrder()
        loadOrders()

        return binding?.root
    }

    private fun initRecyclerOrder() {
        binding?.listOrders?.layoutManager =  LinearLayoutManager(context)
        orderAdapter = CheckoutAdaptor()
        binding?.listOrders?.adapter = orderAdapter
    }

    private fun loadOrders() {
        orderLocalViewModel.loadOrder.observe(viewLifecycleOwner, Observer {
            orderAdapter?.setList(it)
            orderAdapter?.notifyDataSetChanged()
        })
    }

}