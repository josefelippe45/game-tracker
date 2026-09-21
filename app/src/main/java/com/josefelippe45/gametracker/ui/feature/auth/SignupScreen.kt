package com.josefelippe45.gametracker.ui.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josefelippe45.gametracker.ui.components.GTBackButton
import com.josefelippe45.gametracker.ui.components.GTButton
import com.josefelippe45.gametracker.ui.components.GTTextField
import com.josefelippe45.gametracker.ui.theme.GameTrackerTheme

@Composable
fun SignupScreen(
    viewModel: SignupViewModel = viewModel(),
    onBack: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color((0xFF06141B)))
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        GTBackButton(
            modifier = Modifier.absoluteOffset(x = 24.dp, y = 16.dp),
            onClick = onBack
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Criar Conta",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TextUnit(value = 16f, TextUnitType.Sp),
                    color = Color(0xFF9BA8AB)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Crie sua conta",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(value = 28f, TextUnitType.Sp),
                    color = Color(0xFFCCD0CF)
                )
                Text(
                    "Preencha os dados abaixo para começar sua jornada",
                    fontWeight = FontWeight.Medium,
                    fontSize = TextUnit(value = 14f, TextUnitType.Sp),
                    color = Color(0xFF9BA8AB)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                FormRow(
                    fieldName = "Nome Completo",
                    fieldLabel = "Seu nome completo",
                    fieldValue = uiState.name,
                    leadingIcon = Icons.Default.Person,
                    onChangeField = { text -> viewModel.onNameChange(text) }
                )
                FormRow(
                    fieldName = "E-mail",
                    fieldLabel = "seu.email@exemplo.com",
                    fieldValue = uiState.email,
                    leadingIcon = Icons.Default.MarkEmailUnread,
                    onChangeField = { text -> viewModel.onEmailChange(text) }
                )
                FormRow(
                    fieldName = "Senha",
                    fieldLabel = "Criar senha forte",
                    fieldValue = uiState.password,
                    leadingIcon = Icons.Default.Lock,
                    onChangeField = { text -> viewModel.onPasswordChange(text) }
                )
                FormRow(
                    fieldName = "Confirmar Senha",
                    fieldLabel = "Repita a sua senha",
                    fieldValue = uiState.passwordConfirmation,
                    leadingIcon = Icons.Default.Lock,
                    onChangeField = { text -> viewModel.onPasswordConfirmationChange(text) }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GTButton(
                "Cadastrar",
                onClick = {}
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
            ) {
                Text(
                    "Já tem uma conta?",
                    color = Color(0xFFCCD0CF),
                    fontWeight = FontWeight.Medium,
                    fontSize = TextUnit(value = 14f, type = TextUnitType.Sp)
                )
                Text(
                    "Faça login",
                    color = Color(0xFF9BA8AB),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
                    textDecoration = TextDecoration.Underline,
                )
            }
        }

    }
}

@Composable
fun FormRow(
    fieldName: String,
    fieldLabel: String,
    fieldValue: String,
    leadingIcon: ImageVector,
    onChangeField: (text: String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            fieldName,
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(value = 12f, TextUnitType.Sp),
            color = Color(0xFFCCD0CF)
        )
        GTTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fieldValue,
            label = fieldLabel,
            leadingIcon = leadingIcon,
            onChange = onChangeField
        )
    }
}