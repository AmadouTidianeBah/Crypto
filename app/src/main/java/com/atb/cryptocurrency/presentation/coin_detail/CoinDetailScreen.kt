package com.atb.cryptocurrency.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CoinDetailDescription(coinDetail = coinDetail)
                    CoinDetailTagSection(tags = coinDetail.tags)
                    CoinDetailTeamSection(teams = coinDetail.team)
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