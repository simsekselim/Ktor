package com.simsekselim.ktor.presentation.home

import com.simsekselim.ktor.R
import com.simsekselim.ktor.databinding.FragmentHomeBinding
import com.simsekselim.ktor.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
)