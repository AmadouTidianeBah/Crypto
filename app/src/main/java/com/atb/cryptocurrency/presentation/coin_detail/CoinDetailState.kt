package com.atb.cryptocurrency.presentation.coin_detail

import com.atb.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val coinDetail: CoinDetail? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
