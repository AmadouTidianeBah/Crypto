package com.atb.cryptocurrency.presentation.coin_list

import com.atb.cryptocurrency.domain.model.Coin

data class CoinListState(
    val coins: List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
