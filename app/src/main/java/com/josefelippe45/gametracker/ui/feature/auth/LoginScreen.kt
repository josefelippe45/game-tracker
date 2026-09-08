package com.josefelippe45.gametracker.ui.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josefelippe45.gametracker.R
import com.josefelippe45.gametracker.ui.components.GTBackButton
import com.josefelippe45.gametracker.ui.components.GTButton
import com.josefelippe45.gametracker.ui.components.GTTextField
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onBack: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.welcome_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        GTBackButton(
            modifier = Modifier.absoluteOffset(x = 16.dp, y = 24.dp),
            onClick = onBack
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(color = Color(0xFF11212D))
                .padding(horizontal = 32.dp, vertical = 32.dp),

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Bem vindo",
                    color = Color(0xFFCCD0CF),
                    fontWeight = FontWeight(500),
                    fontSize = TextUnit(value = 24f, type = TextUnitType.Sp)
                )
                Text(
                    "Faça login na sua conta",
                    color = Color(0xFFCCD0CF),
                    fontWeight = FontWeight(500),
                    fontSize = TextUnit(value = 14f, type = TextUnitType.Sp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                GTTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.email,
                    label = "Email",
                    placeholder = "example@example.com",
                    onChange = { text -> viewModel.onEmailChange(text) }
                )
                GTTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.password,
                    label = "Password",
                    onChange = { text -> viewModel.onPasswordChange(text) }
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GTButton(text = "Login", onClick = fun () {})
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                ) {
                    Text(
                        "Ainda não tem conta?",
                        color = Color(0xFFCCD0CF),
                        fontWeight = FontWeight(500),
                        fontSize = TextUnit(value = 14f, type = TextUnitType.Sp)
                    )
                    Text(
                        "Cadastre-se",
                        color = Color(0xFF9BA8AB),
                        fontWeight = FontWeight(500),
                        fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
                        textDecoration = TextDecoration.Underline,
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GTTextFieldPreview() {
    GameTrackerTheme() {
        LoginScreen()
    }
}