package com.atb.cryptocurrency.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atb.cryptocurrency.core.Resources
import com.atb.cryptocurrency.domain.use_cases.CryptoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val cryptoUseCases: CryptoUseCases
): ViewModel() {
    private var _uiState = MutableStateFlow(CoinListState())
    val uiState: StateFlow<CoinListState> = _uiState

    init {
        getCoins()
    }
    private fun getCoins() {
        cryptoUseCases.getCoins().onEach {result ->
            when(result) {
                is Resources.Error -> _uiState.update { it.copy(errorMessage = result.message ?: "An unexpected error occur") }
                is Resources.Loading -> _uiState.update { it.copy(isLoading = true) }
                is Resources.Success -> _uiState.update { it.copy(coins = result.data ?: emptyList()) }
            }
        }.launchIn(viewModelScope)
    }
}