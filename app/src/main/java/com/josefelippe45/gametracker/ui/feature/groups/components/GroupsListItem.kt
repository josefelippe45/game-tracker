package com.josefelippe45.gametracker.ui.feature.groups.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GroupsListItem(title: String, onlinePlayers: Int, modifier: Modifier = Modifier) {
    Card() {
        Row() {
            Text(text = title)
            Spacer(Modifier.width(8.dp))
            Text(text = onlinePlayers.toString())
        }
    }
}