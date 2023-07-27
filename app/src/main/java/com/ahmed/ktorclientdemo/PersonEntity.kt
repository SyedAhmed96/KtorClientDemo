package com.ahmed.ktorclientdemo

import kotlinx.serialization.Serializable

@Serializable
data class PersonEntity(
    val id: String,
    val firstname: String,
    val lastname: String
)
