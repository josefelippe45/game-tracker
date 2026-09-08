package com.josefelippe45.gametracker.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme

@Composable
fun GTTextField(
    value: String,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String = "",
    onChange: (text: String) -> Unit,
) {
    TextField(
        value=value,
        onValueChange = onChange,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GTTextFieldPreview() {
    GameTrackerTheme() {
        GTTextField(
            "",
            label = "Label",
            placeholder = "Placeholder",
            onChange = fun (text: String) {}
        )
    }
}