package com.mungaicodes.rickymortyapi.presentation.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.SafetyDivider
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mungaicodes.rickymortyapi.domain.model.Character
import com.mungaicodes.rickymortyapi.presentation.character_detail.components.CharacterImage
import com.mungaicodes.rickymortyapi.presentation.character_detail.components.DetailProperty
import com.mungaicodes.rickymortyapi.presentation.character_detail.components.mirroringBackIcon

@Composable
fun DetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    upPress: () -> Unit
) {
    val state = viewModel.uiState.collectAsState().value
    DetailContent(
        character = state.character,
        upPress = upPress
    )
}

@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    character: Character?,
    upPress: () -> Unit
) {
    Box(modifier.fillMaxSize()) {
        Column {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                character = character
            )
            Body(character = character)
        }
        Up(upPress)
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    character: Character?
) {
    Column(
        modifier = modifier.background(Color(0xffffe0b2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterImage(image = character?.image)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = character?.name ?: "",
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
    }
}

@Composable
private fun Body(character: Character?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        character?.species?.let {
            DetailProperty(
                label = "Specie",
                value = it,
                imageVector = Icons.Filled.EmojiPeople
            )
        }
        character?.status?.let {
            DetailProperty(
                label = "Status",
                value = it,
                imageVector = Icons.Outlined.Help
            )
        }
        character?.gender?.let {
            DetailProperty(
                label = "Gender",
                value = it,
                imageVector = Icons.Outlined.SafetyDivider
            )
        }
        character?.origin?.name?.let {
            DetailProperty(
                label = "First seen in:",
                value = it,
                imageVector = Icons.Outlined.Visibility
            )
        }
        character?.location?.name?.let {
            DetailProperty(
                label = "Last known location",
                value = it,
                imageVector = Icons.Outlined.LocationOn
            )
        }
    }
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .size(36.dp)
    ) {
        Icon(
            imageVector = mirroringBackIcon(),
            tint = Color(0xffffffff),
            contentDescription = null
        )
    }
}