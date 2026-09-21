package com.josefelippe45.gametracker.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme

@Composable
fun GTButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled && !isLoading,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF11212D),
            contentColor = Color(0xFFCCD0CF),
        ),
        border = BorderStroke(1.dp, Color(0xFF253745)),
        shape = RoundedCornerShape(16.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(20.dp))
            return@Button
        }
        Text(text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GTButtonPreview() {
    GameTrackerTheme() {
        GTButton("Texto teste", onClick = fun() {})
    }
}