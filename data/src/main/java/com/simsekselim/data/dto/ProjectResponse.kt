package com.simsekselim.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProjectResponse(
    val description: String,
    val image: String,
    val link: String,
    val title: String
)