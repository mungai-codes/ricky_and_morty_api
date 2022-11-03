package com.mungaicodes.rickymortyapi.presentation.character_detail

import com.mungaicodes.rickymortyapi.domain.model.Character

data class CharacterDetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)
