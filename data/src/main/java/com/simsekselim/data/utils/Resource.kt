package com.simsekselim.data.utils

import com.simsekselim.domain.utils.Resource

/**
 * @Author: Selim Simsek
 * @Date: 7.03.2023
 */


fun <T> safeApiCall(
    response: T,
): Resource<T> {
    return try {
        Resource.Success(data = response)
    } catch (e: Exception) {
        Resource.Error(e.message ?: e.toString())
    }
}
