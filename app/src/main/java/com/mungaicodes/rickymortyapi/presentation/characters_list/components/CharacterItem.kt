package com.mungaicodes.rickymortyapi.presentation.characters_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.mungaicodes.rickymortyapi.domain.model.Characters
import com.mungaicodes.rickymortyapi.ui.theme.ColorPrimary

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character: Characters,
    onItemClicked: (Int) -> Unit
) {

    Card(
        modifier = modifier
            .clickable { onItemClicked(character.id) }
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp),
        elevation = 4.dp,
        border = BorderStroke(1.dp, ColorPrimary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(modifier = Modifier.size(64.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(character.image)
                        .size(Size.ORIGINAL)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(2.dp))
                        .padding(1.dp)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    //align element center vertically within the row
                    .align(CenterVertically),
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h6
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = character.specie,
                        style = MaterialTheme.typography.caption
                    )
                }

            }

        }
    }

}