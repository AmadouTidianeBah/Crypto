package com.atb.cryptocurrency.presentation.navigation

sealed class CryptoNavRoute(val route: String) {
    object CoinList: CryptoNavRoute("coin_list")
    object CoinDetail: CryptoNavRoute("coin_detail")
}
