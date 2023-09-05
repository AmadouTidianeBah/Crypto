package com.atb.cryptocurrency.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atb.cryptocurrency.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onCoinClick: (Coin) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onCoinClick(coin) }
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            fontSize = 20.sp
        )
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
