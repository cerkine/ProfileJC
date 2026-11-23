package com.example.profilejc.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun ShowProfile(modifier: Modifier, onEditPress: () -> Unit, profileViewModel: ProfileViewModel) {
    // 1. Observamos el estado único del ViewModel
    val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()

    // 2. Desestructuramos si quieres mantener la sintaxis corta que buscabas
    val (name, surname, email, isError) = uiState



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            label = { Text("Name") },
            value = name,
            onValueChange = { },
            enabled = false
        )
        OutlinedTextField(
            label = { Text("Surname") },
            value = surname,
            onValueChange = { },
            enabled = false
        )
        OutlinedTextField(
            label = { Text("Email") },
            value = email,
            onValueChange = {},
            enabled = false
        )
        Button(
            onClick = { onEditPress() }
        ) {
            Text("Edit")
        }
    }
}