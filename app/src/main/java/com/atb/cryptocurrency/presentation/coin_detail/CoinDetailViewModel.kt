package com.atb.cryptocurrency.presentation.coin_detail

import androidx.lifecycle.SavedStateHandle
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
class CoinDetailViewModel @Inject constructor(
    private val cryptoUseCases: CryptoUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _uiState = MutableStateFlow(CoinDetailState())
    val uiState: StateFlow<CoinDetailState> = _uiState

    init {
        savedStateHandle.get<String>("coinId")?.let {coinId ->
            getCoin(coinId)
        }
    }
    private fun getCoin(coinId: String) {
        cryptoUseCases.getCoinDetail(coinId).onEach { result ->
            when(result) {
                is Resources.Error -> _uiState.update { it.copy(errorMessage = result.message ?: "An unexpected error occur", isLoading = false) }
                is Resources.Loading -> _uiState.update { it.copy(isLoading = true) }
                is Resources.Success -> _uiState.update { it.copy(coinDetail = result.data, isLoading = false) }
            }
        }.launchIn(viewModelScope)
    }
}