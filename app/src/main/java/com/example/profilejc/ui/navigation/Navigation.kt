package com.example.profilejc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profilejc.ui.screen.profile.EditProfile
import com.example.profilejc.ui.screen.profile.ProfileViewModel
import com.example.profilejc.ui.screen.profile.ShowProfile


@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()
    val profileViewModel: ProfileViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.ShowProfile.route
    ) {
        composable(Routes.ShowProfile.route) {
            ShowProfile(
                modifier = modifier,
                onEditPress = {
                    navController.navigate(Routes.EditProfile.route)
                },
                profileViewModel = profileViewModel
            )
        }

        composable(Routes.EditProfile.route) {
            EditProfile(
                modifier = modifier,
                navigate = { navController.popBackStack() },
                profileViewModel = profileViewModel

            )
        }
    }
}