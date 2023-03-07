package com.simsekselim.ktor.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.simsekselim.ktor.BR
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch


/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */
abstract class BaseFragment<TViewModel : BaseViewModel, TBinding : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    private val viewModelType: Class<TViewModel>
) : Fragment() {

    lateinit var viewModel: TViewModel
    lateinit var binding: TBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[viewModelType]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root

    }
}