package com.atb.cryptocurrency.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.atb.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.atb.cryptocurrency.presentation.coin_list.CoinListScreen

@Composable
fun CryptoNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "coin_list",
        modifier = modifier
    ) {
        composable(route = CryptoNavRoute.CoinList.route) {
            CoinListScreen(
                onCoinClick = {
                    navController.navigate(CryptoNavRoute.CoinDetail.route + "/${it.id}")
                }
            )
        }

        composable(
            route = CryptoNavRoute.CoinDetail.route + "/{coinId}",
            arguments = listOf(
                navArgument("coinId"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            CoinDetailScreen()
        }
    }
}