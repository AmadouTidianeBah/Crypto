package com.atb.cryptocurrency.domain.use_cases.coin_detail

import com.atb.cryptocurrency.core.Resources
import com.atb.cryptocurrency.domain.model.CoinDetail
import com.atb.cryptocurrency.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class GetCoinDetailUseCase(
    private val repository: CryptoRepository
) {
    operator fun invoke(coinId: String): Flow<Resources<CoinDetail>> = flow {
        try {
            emit(Resources.Loading())
            val data = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resources.Success(data))
        } catch (e: IOException) {
            emit(Resources.Error(e.message ?: "Couldn't get the data, check your connection!"))
        } catch (e: HttpException) {
            emit(Resources.Error(e.message ?: "An unexpected error occur"))
        }
    }
}