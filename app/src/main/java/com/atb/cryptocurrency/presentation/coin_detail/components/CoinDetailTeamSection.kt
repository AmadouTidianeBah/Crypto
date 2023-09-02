package com.atb.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atb.cryptocurrency.data.remote.dto.Team
import com.atb.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme

@Composable
fun CoinDetailTeamSection(
    modifier: Modifier = Modifier,
    teams: List<Team>
) {
    LazyColumn(
        modifier =  modifier
    ) {
        items(items = teams, key = {it.id}) { member ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = member.name, fontSize = 20.sp)

                Text(
                    text = member.position,
                    color = Color.Cyan,
                    fontStyle = FontStyle.Italic
                )
            }
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pre() {
    CryptoCurrencyTheme {
        LazyColumn(
            Modifier.fillMaxSize()
        ) {
            repeat(20) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Satoshi Nakamoto", fontSize = 20.sp)

                        Text(
                            text = "Founder",
                            color = Color.Cyan,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Divider()
                }
            }
        }
    }
}
