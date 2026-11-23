package com.example.profilejc.ui.navigation

sealed class Routes(val route: String){
    object EditProfile : Routes( route = "edit_profile")
    object ShowProfile : Routes( route = "show_profile")

}
