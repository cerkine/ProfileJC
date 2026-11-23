package com.example.profilejc.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun ShowProfile(modifier: Modifier, onEditPress: () -> Unit, profileViewModel: ProfileViewModel){
    var name = profileViewModel.name
    var surname = profileViewModel.surname
    var email = profileViewModel.email
    var isError = profileViewModel.isError



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            label = { Text("Name") },
            value = name,
            onValueChange = { changed: String -> name = changed },
            enabled = false
        )
        OutlinedTextField(
            label = { Text("Surname") },
            value = surname,
            onValueChange = { changed: String -> surname = changed },
            enabled = false
        )
        OutlinedTextField(
            label = { Text("Email") },
            value = email,
            onValueChange = { changed: String -> email = changed },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            supportingText = {
                if (isError) {
                    Text("Please enter a valid email address")
                }
            },
            enabled = false
        )
        Button(
            onClick = {onEditPress()}
        ) {
            Text("Submit")
        }
    }
}