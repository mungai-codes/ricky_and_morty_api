package com.mungaicodes.rickymortyapi.presentation.characters_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungaicodes.rickymortyapi.domain.repository.CharacterRepository
import com.mungaicodes.rickymortyapi.util.Resource
import com.mungaicodes.rickymortyapi.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val repo: CharacterRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharactersListState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPage = 1

    init {
        getAllCharacters(increase = false)
    }

    fun getAllCharacters(increase: Boolean) {
        viewModelScope.launch {
            if (increase) currentPage++ else if (currentPage > 1) currentPage--
            val showPreviousPage = currentPage > 1
            val showNext = currentPage < 42
            repo.getAllCharacters(currentPage).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                characters = result.data ?: emptyList(),
                                isLoading = false,
                                showPrevious = showPreviousPage,
                                showNext = showNext
                            )
                        }
                    }
                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(isLoading = false)
                        }
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            )
                        )
                    }
                    is Resource.Loading -> {
                        _uiState.update {
                            it.copy(isLoading = true)
                        }
                    }
                }
            }.launchIn(this)
        }
    }

}