@file:OptIn(ExperimentalMaterial3Api::class)

package com.atb.cryptocurrency.core.presentation.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CryptoTopBar(
    modifier: Modifier = Modifier,
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        },
        modifier = modifier
    )
}