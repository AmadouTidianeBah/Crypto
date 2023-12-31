package com.atb.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atb.cryptocurrency.domain.model.CoinDetail

@Composable
fun CoinDetailDescription(
    modifier: Modifier = Modifier,
    coinDetail: CoinDetail
) {
   Column(
       modifier = modifier.fillMaxWidth(),
       verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {
       Row(
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .fillMaxWidth()
       ) {
           Text(
               text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
               fontSize = 18.sp
           )
           Text(
               text = if (coinDetail.isActive) "Active" else "Inactive",
               fontStyle = FontStyle.Italic,
               color = MaterialTheme.colorScheme.primary,
           )
       }

       if (coinDetail.description.isNotBlank()) {
           Text(text = coinDetail.description, style = MaterialTheme.typography.bodyMedium)
       } else {
           Text(text = "No description available...", style = MaterialTheme.typography.bodyMedium)
       }
   }
}