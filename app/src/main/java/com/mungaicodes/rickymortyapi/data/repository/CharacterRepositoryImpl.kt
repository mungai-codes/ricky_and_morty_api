package com.mungaicodes.rickymortyapi.data.repository

import com.mungaicodes.rickymortyapi.data.mapper.toCharacter
import com.mungaicodes.rickymortyapi.data.mapper.toListCharacters
import com.mungaicodes.rickymortyapi.data.remote.RickyAndMortyApi
import com.mungaicodes.rickymortyapi.domain.model.Character
import com.mungaicodes.rickymortyapi.domain.model.Characters
import com.mungaicodes.rickymortyapi.domain.repository.CharacterRepository
import com.mungaicodes.rickymortyapi.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickyAndMortyApi
) : CharacterRepository {

    override fun getAllCharacters(page: Int): Flow<Resource<List<Characters>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = api.getAllCharacters(page).toListCharacters()
                emit(
                    Resource.Success(
                        data = response
                    )
                )
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = "Oops, something went wrong" + e.localizedMessage,
                        data = null
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = "Couldn't reach server, check your internet connection" + e.localizedMessage,
                        data = null
                    )
                )
            }
        }
    }

    override suspend fun getCharacterById(id: Int): Resource<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred" + e.localizedMessage)
        }
        return Resource.Success(response.toCharacter())
    }
}