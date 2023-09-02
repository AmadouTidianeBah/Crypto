package com.atb.cryptocurrency.domain.repository

import com.atb.cryptocurrency.data.remote.dto.CoinDetailDto
import com.atb.cryptocurrency.data.remote.dto.CoinDto

interface CryptoRepository {
    suspend fun getAllCoins(): List<CoinDto>
    suspend fun getCoinDetail(coinId: String): CoinDetailDto
}