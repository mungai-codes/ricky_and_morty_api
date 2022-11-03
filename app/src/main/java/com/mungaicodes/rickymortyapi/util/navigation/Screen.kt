package com.mungaicodes.rickymortyapi.util.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail?id={id}") {
        fun passId(id: Int): String {
            return "detail?id=$id"
        }
    }
}
