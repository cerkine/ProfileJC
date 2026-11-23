package com.example.profilejc.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditProfile(modifier: Modifier, onConfirm: () -> Unit, profileViewModel: ProfileViewModel) {
    var name by remember {  mutableStateOf(profileViewModel.name)}
    var surname by remember { mutableStateOf(profileViewModel.surname)}
    var email by remember {mutableStateOf(profileViewModel.email)}
    var isError by remember {  mutableStateOf(profileViewModel.isError)}

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text("Edit Screen")

        OutlinedTextField(
            label = { Text("Name") },
            value = name,
            onValueChange = { changed: String -> name = changed })
        OutlinedTextField(
            label = { Text("Surname") },
            value = surname,
            onValueChange = { changed: String -> surname = changed })
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
        )
        Button(
            onClick = {
                isError = !profileViewModel.validateEmail(email)
                if (!isError) {
                    profileViewModel.updateData(newName = name, newSurname = surname, newEmail = email, newIsError = isError)
                    onConfirm()
                }
            }
        ) {
            Text("Submit")
        }
    }
}