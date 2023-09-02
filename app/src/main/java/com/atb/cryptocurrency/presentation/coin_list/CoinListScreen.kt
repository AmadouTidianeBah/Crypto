package com.atb.cryptocurrency.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.atb.cryptocurrency.core.presentation.components.CryptoTopBar
import com.atb.cryptocurrency.domain.model.Coin
import com.atb.cryptocurrency.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    onCoinClick: (Coin) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CryptoTopBar(title = "Coins")
        },
        modifier = modifier
    ) {innerPadding ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(items = state.value.coins, key = { it.id }) { coin ->
                    CoinListItem(
                        coin = coin,
                        onCoinClick = onCoinClick
                    )
                    Divider()
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