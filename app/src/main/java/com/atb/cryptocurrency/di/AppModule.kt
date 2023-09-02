package com.atb.cryptocurrency.di

import com.atb.cryptocurrency.data.remote.CoinPaprikaApi
import com.atb.cryptocurrency.data.repository.CryptoRepositoryImpl
import com.atb.cryptocurrency.domain.repository.CryptoRepository
import com.atb.cryptocurrency.domain.use_cases.CryptoUseCases
import com.atb.cryptocurrency.domain.use_cases.coin_detail.GetCoinDetailUseCase
import com.atb.cryptocurrency.domain.use_cases.coin_list.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CoinPaprikaApi.BASE_URL)
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CoinPaprikaApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCryptoUseCases(repository: CryptoRepository): CryptoUseCases {
        return CryptoUseCases(
            getCoins = GetCoinsUseCase(repository),
            getCoinDetail = GetCoinDetailUseCase(repository)
        )
    }
}