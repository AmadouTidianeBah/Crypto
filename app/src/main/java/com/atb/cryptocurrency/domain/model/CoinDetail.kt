package com.atb.cryptocurrency.domain.model

import com.atb.cryptocurrency.data.remote.dto.Tag
import com.atb.cryptocurrency.data.remote.dto.Team

data class CoinDetail(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>
)
