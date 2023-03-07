package com.simsekselim.ktor.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */
open class BaseViewModel : ViewModel(){

    fun viewModelLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.Main, block = block)
    }

}