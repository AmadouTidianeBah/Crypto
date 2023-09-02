package com.atb.cryptocurrency.domain.use_cases.coin_list

import com.atb.cryptocurrency.core.Resources
import com.atb.cryptocurrency.domain.model.Coin
import com.atb.cryptocurrency.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class GetCoinsUseCase(
    private val repository: CryptoRepository
) {
    operator fun invoke(): Flow<Resources<List<Coin>>> = flow {
        try {
            emit(Resources.Loading())
            val data = repository.getAllCoins().map { it.toCoin() }
            emit(Resources.Success(data))
        } catch (e: IOException) {
            emit(Resources.Error(e.message ?: "Couldn't get the data, check your connection!"))
        } catch (e: HttpException) {
            emit(Resources.Error(e.message ?: "An unexpected error occur"))
        }
    }
}