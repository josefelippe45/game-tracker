package com.josefelippe45.gametracker.ui.feature.groups

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

data class User(
    val id: String = UUID.randomUUID().toString(),
    val username: String
)

data class Group(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val users: List<User>
)

data class GroupsUiState(
    val groups: List<Group> = List<Group>(2, init = {index -> Group(title = "Grupo $index", users = emptyList())}),
    val isLoading: Boolean = false
)

class GroupsViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GroupsUiState())
    val uiState: StateFlow<GroupsUiState> = _uiState.asStateFlow()

    fun addGroup(title: String) {
        if (title.isBlank()) return

        val newGroup = Group(title = title.trim(), users = emptyList())
        _uiState.update { current -> current.copy(groups = current.groups + newGroup) }
    }

    fun removeGroup(id: String) {
        _uiState.update { current -> current.copy(groups = current.groups.filter { it.id != id }) }
    }
}