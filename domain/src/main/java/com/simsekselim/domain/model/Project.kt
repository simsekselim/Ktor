package com.simsekselim.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val description: String,
    val image: String,
    val link: String,
    val title: String
)