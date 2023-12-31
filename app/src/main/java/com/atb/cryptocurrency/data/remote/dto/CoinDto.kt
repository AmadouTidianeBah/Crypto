package com.atb.cryptocurrency.data.remote.dto

import com.atb.cryptocurrency.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) {
    fun toCoin(): Coin {
        return Coin(id, isActive, name, rank, symbol)
    }
}