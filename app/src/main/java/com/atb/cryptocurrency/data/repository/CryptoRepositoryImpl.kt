package com.atb.cryptocurrency.data.repository

import com.atb.cryptocurrency.data.remote.CoinPaprikaApi
import com.atb.cryptocurrency.data.remote.dto.CoinDetailDto
import com.atb.cryptocurrency.data.remote.dto.CoinDto
import com.atb.cryptocurrency.domain.repository.CryptoRepository

class CryptoRepositoryImpl(
    private val api: CoinPaprikaApi
) : CryptoRepository {
    override suspend fun getAllCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }
}