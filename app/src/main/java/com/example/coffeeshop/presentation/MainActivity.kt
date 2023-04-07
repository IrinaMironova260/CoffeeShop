package com.example.coffeeshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.ActivityMainBinding
import com.example.coffeeshop.presentation.tabs.Home
import com.example.coffeeshop.presentation.tabs.account.Account
import com.example.coffeeshop.presentation.tabs.card.Card
import com.example.coffeeshop.presentation.tabs.coffee.Coffee
import com.example.coffeeshop.presentation.viewModels.CardViewModel
import com.example.coffeeshop.presentation.viewModels.CoffeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val coffeeViewModel: CoffeeViewModel by viewModel()
    private val cardViewModel: CardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        coffeeViewModel.migration(this)

        setSupportActionBar(binding?.topMainMenu)
        loadCoffeeToCard()
        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()

        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()
                R.id.coffeeBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Coffee()).commit()
                R.id.cardBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Card()).commit()
                R.id.accountBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Account()).commit()
            }
            return@setOnItemSelectedListener true

        }
        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu

    }
    private fun loadCoffeeToCard (){
        cardViewModel.loadCoffeeFromCard.observe(this, Observer {
            val count = it.count()
            val badge = binding?.bottomMainMenu?.getOrCreateBadge(R.id.cardBottomMainMenu)
            badge?.isVisible = count>0
            badge?.number = count
        })
    }
}