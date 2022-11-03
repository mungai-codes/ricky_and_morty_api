package com.mungaicodes.rickymortyapi.domain.model

import com.mungaicodes.rickymortyapi.data.remote.dto.Location
import com.mungaicodes.rickymortyapi.data.remote.dto.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String
)
