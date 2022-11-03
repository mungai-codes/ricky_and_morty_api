package com.mungaicodes.rickymortyapi.domain.repository

import com.mungaicodes.rickymortyapi.domain.model.Character
import com.mungaicodes.rickymortyapi.domain.model.Characters
import com.mungaicodes.rickymortyapi.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters(page: Int): Flow<Resource<List<Characters>>>

    suspend fun getCharacterById(id: Int): Resource<Character>


}