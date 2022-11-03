package com.mungaicodes.rickymortyapi.di

import com.mungaicodes.rickymortyapi.data.remote.RickyAndMortyApi
import com.mungaicodes.rickymortyapi.data.repository.CharacterRepositoryImpl
import com.mungaicodes.rickymortyapi.domain.repository.CharacterRepository
import com.mungaicodes.rickymortyapi.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickyAndMortyApi(): RickyAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickyAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: RickyAndMortyApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}