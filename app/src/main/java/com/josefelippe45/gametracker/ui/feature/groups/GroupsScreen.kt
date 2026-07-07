package com.josefelippe45.gametracker.ui.feature.groups

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josefelippe45.gametracker.ui.feature.groups.components.GroupsList

@Composable
fun GroupsScreen(viewModel: GroupsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    GroupsList(groups = uiState.groups)
}