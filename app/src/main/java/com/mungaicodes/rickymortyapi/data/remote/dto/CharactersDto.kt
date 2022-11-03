package com.mungaicodes.rickymortyapi.data.remote.dto

import com.example.rickandmorty.data.source.remote.dto.Info

data class CharactersDto(
    val info: Info,
    val results: List<Result>
)



