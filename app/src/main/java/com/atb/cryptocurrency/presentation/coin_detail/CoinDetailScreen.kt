package com.atb.cryptocurrency.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.atb.cryptocurrency.core.presentation.components.CryptoTopBar
import com.atb.cryptocurrency.presentation.coin_detail.components.CoinDetailDescription
import com.atb.cryptocurrency.presentation.coin_detail.components.CoinDetailTagSection
import com.atb.cryptocurrency.presentation.coin_detail.components.CoinDetailTeamSection

@Composable
fun CoinDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState()

    state.value.coinDetail?.let {coinDetail ->
        Scaffold(
            topBar = {
                CryptoTopBar(title = coinDetail.name)
            },
            modifier = modifier
        ) {innerPadding ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                LazyColumn (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    item {
                        CoinDetailDescription(coinDetail = coinDetail)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "TAG :",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CoinDetailTagSection(tags = coinDetail.tags)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Team :",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    if (coinDetail.team.isNotEmpty()) {
                        items(coinDetail.team) {member ->
                            CoinDetailTeamSection(member = member)
                            Divider()
                        }
                    } else {
                        item {
                            Text(text = "No member available...")
                        }
                    }
                }
                if (state.value.isLoading) CircularProgressIndicator()
                if (state.value.errorMessage.isNotBlank()) Text(
                    text = state.value.errorMessage,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}