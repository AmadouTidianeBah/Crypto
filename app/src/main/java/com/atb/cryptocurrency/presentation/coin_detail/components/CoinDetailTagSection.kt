@file:OptIn(ExperimentalLayoutApi::class)

package com.atb.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.atb.cryptocurrency.data.remote.dto.Tag

@Composable
fun CoinDetailTagSection(
    modifier: Modifier = Modifier,
    tags: List<Tag>
) {
    FlowColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.forEach {tag ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .border(
                        8.dp,
                        Color.Cyan,
                        CircleShape
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = tag.name,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}