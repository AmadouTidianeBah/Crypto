package com.atb.cryptocurrency.domain.use_cases

import com.atb.cryptocurrency.domain.use_cases.coin_detail.GetCoinDetailUseCase
import com.atb.cryptocurrency.domain.use_cases.coin_list.GetCoinsUseCase

data class CryptoUseCases(
    val getCoins: GetCoinsUseCase,
    val getCoinDetail: GetCoinDetailUseCase
)
