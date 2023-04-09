package com.example.coffeeshop.presentation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.coffeeshop.databinding.HomeBinding
import com.example.coffeeshop.presentation.proposal.ProposalAdapter
import com.google.android.material.tabs.TabLayoutMediator


class Home : Fragment() {

    private var binding: HomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeBinding.inflate(inflater, container, false)

        binding?.slider?.adapter = ProposalAdapter(context as FragmentActivity)

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator?.attach()

        return binding?.root
    }
}