package com.mungaicodes.rickymortyapi.presentation.characters_list

import com.mungaicodes.rickymortyapi.domain.model.Characters

data class CharactersListState(
    val characters: List<Characters> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)
