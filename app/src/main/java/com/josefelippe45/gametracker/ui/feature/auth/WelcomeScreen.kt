package com.josefelippe45.gametracker.ui.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.josefelippe45.gametracker.R
import com.josefelippe45.gametracker.ui.components.GTButton
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme
import com.josefelippe45.gametracker.ui.theme.InterFontFamily

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.welcome_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xB306141B),
                            Color.Transparent
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(0f, 900f)
                    )
                )
                .padding(horizontal = 32.dp, vertical = 64.dp)

        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "O melhor aplicativo para jogar com seus amigos!",
                fontWeight = FontWeight.ExtraBold,
                fontSize = TextUnit(value = 28f, type = TextUnitType.Sp),
                lineHeight = TextUnit(value = 1.2f, type = TextUnitType.Em),
                letterSpacing = TextUnit(value = 0f, type = TextUnitType.Em),
                textAlign = TextAlign.Center,
                color = Color(0xFFCCD0CF),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                GTButton(text = "Login", onClick = onLoginClick)
                GTButton(text = "Cadastre-se", onClick = onSignUpClick)
            }
        }
    }
}