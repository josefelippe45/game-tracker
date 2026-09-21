package com.josefelippe45.gametracker.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme

@Composable
fun GTTextField(
    value: String,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    onChange: (text: String) -> Unit,
) {
    OutlinedTextField(
        value=value,
        onValueChange = onChange,
        placeholder = { if (placeholder != null) Text(text = placeholder) else Text(text = label) },
        leadingIcon = leadingIcon?.let { {Icon(it, contentDescription = null)} },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF11212D),
            unfocusedContainerColor = Color(0xFF11212D),
            focusedTextColor = Color(0xFF9BA8AB),
            unfocusedTextColor = Color(0xFF9BA8AB),
            focusedLeadingIconColor = Color(0xFF9BA8AB),
            unfocusedLeadingIconColor = Color(0xFF9BA8AB),
            focusedPlaceholderColor = Color(0xFF9BA8AB),
            unfocusedPlaceholderColor = Color(0xFF9BA8AB),
            focusedIndicatorColor = Color(0xFF253745),
            unfocusedIndicatorColor =  Color(0xFF253745)
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier,

    )
}

@Preview(showBackground = true)
@Composable
fun GTTextFieldPreview() {
    GameTrackerTheme() {
        GTTextField(
            "",
            label = "Label",
            onChange = fun (text: String) {}
        )
    }
}