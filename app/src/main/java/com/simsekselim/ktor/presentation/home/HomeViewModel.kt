package com.simsekselim.ktor.presentation.home

import com.simsekselim.data.repository.ProjectsRepositoryImpl
import com.simsekselim.domain.utils.Resource
import com.simsekselim.ktor.BuildConfig
import com.simsekselim.ktor.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProjectsRepositoryImpl
) : BaseViewModel() {

    init {
        fetchProjects()
    }

    private fun fetchProjects() {
        viewModelLaunch {
            repository.getAllProjects().collect {
                when (it) {
                    is Resource.Loading -> {
                        // Loading
                    }
                    is Resource.Success -> {
                        // Success
                    }
                    is Resource.Error -> {
                        // Error
                    }
                }
            }
        }
    }
}