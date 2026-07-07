package com.josefelippe45.gametracker.ui.feature.groups.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.josefelippe45.gametracker.ui.feature.groups.Group

@Composable
fun GroupsList(groups: List<Group>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(items = groups, key = {group -> group.id}) {
            item -> GroupsListItem(title = item.title, onlinePlayers = item.users.size)
        }
    }
}
