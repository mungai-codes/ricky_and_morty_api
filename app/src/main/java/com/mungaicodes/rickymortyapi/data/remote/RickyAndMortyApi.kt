package com.mungaicodes.rickymortyapi.data.remote

import com.mungaicodes.rickymortyapi.data.remote.dto.CharacterDto
import com.mungaicodes.rickymortyapi.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickyAndMortyApi {

    @GET("character/")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterDto


}

