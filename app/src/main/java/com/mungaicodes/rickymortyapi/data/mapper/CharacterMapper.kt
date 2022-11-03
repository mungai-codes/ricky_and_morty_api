package com.mungaicodes.rickymortyapi.data.mapper

import com.mungaicodes.rickymortyapi.data.remote.dto.CharacterDto
import com.mungaicodes.rickymortyapi.data.remote.dto.CharactersDto
import com.mungaicodes.rickymortyapi.domain.model.Character
import com.mungaicodes.rickymortyapi.domain.model.Characters

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin,
        gender = gender,
        location = location,
        image = image
    )
}

fun CharactersDto.toListCharacters(): List<Characters> {
    val resultEntries = results.mapIndexed { _, entries ->
        Characters(
            id = entries.id,
            name = entries.name,
            specie = entries.species,
            image = entries.image
        )
    }
    return resultEntries
}