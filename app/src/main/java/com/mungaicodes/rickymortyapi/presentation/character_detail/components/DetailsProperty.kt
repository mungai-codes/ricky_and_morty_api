package com.mungaicodes.rickymortyapi.presentation.character_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mungaicodes.rickymortyapi.ui.theme.TextWhite
import com.mungaicodes.rickymortyapi.ui.theme.backGround

@Composable
fun DetailProperty(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    imageVector: ImageVector
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp),
        elevation = 3.dp,
        backgroundColor = backGround
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = TextWhite,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(text = label, fontWeight = FontWeight.Bold, color = TextWhite)
                Spacer(Modifier.height(5.dp))
                Text(
                    text = value,
                    color = TextWhite,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }

}