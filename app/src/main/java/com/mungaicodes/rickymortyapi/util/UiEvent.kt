package com.mungaicodes.rickymortyapi.util

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()
}
