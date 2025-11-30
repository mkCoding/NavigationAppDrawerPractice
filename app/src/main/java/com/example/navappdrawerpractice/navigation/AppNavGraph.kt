package com.example.navappdrawerpractice.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.navappdrawerpractice.presentation.SettingsScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navappdrawerpractice.presentation.AboutScreen
import com.example.navappdrawerpractice.presentation.HomeScreen
import com.example.navappdrawerpractice.presentation.ProfileScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(
            route = Screen.Home.route,
            enterTransition = {slideInFromBottom()}
        ) {
            HomeScreen()
        }
        composable(
            route = Screen.Profile.route,
            enterTransition = { slideInFromRight() },

            ) { ProfileScreen() }
        composable(
            route = Screen.Settings.route,
            enterTransition = { slideInFromRight() },

            ) { SettingsScreen() }
        composable(
            route = Screen.About.route,
            enterTransition = { slideInFromRight() },

            ) { AboutScreen() }

    }
}

sealed class Screen(val route:String){
    object Home:Screen("home")
    object Profile:Screen("profile")
    object Settings:Screen("settings")
    object About:Screen("about")

}

// Animations
fun slideInFromRight(duration: Int = 1000) = slideInHorizontally(
    initialOffsetX = { it }, animationSpec = tween(durationMillis = duration)
) + fadeIn(animationSpec = tween(durationMillis = duration))

fun slideOutToLeft(duration: Int = 400) = slideOutHorizontally(
    targetOffsetX = { -it }, animationSpec = tween(durationMillis = duration)
) + fadeOut(animationSpec = tween(durationMillis = duration))

fun slideInFromBottom(duration: Int = 1000) = slideInVertically(
    initialOffsetY = { fullHeight -> fullHeight }, // start offscreen at the bottom
    animationSpec = tween(durationMillis = duration)
) + fadeIn(animationSpec = tween(durationMillis = duration))
