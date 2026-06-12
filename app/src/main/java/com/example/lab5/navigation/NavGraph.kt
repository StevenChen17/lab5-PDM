package com.example.lab5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab5.view.HomeInitScreen
import com.example.lab5.view.Greeting
import com.example.lab5.viewModel.GeneralViewModel


object Routes {
    const val HOME_INIT = "home_init"
    const val TASKS = "tasks"
}
@Composable
fun AppNavGraph(
    navController: NavHostController,
    generalViewModel: GeneralViewModel
) {
    NavHost(
        navController = navController,
        // Pass the String route here
        startDestination = Routes.HOME_INIT
    ) {
        // Use the route = "" parameter format instead of generic types
        composable(route = Routes.HOME_INIT) {
            HomeInitScreen(
                onNavigateToTasks = { navController.navigate(Routes.TASKS) }
            )
        }
        composable(route = Routes.TASKS) {
            Greeting(viewModel = generalViewModel)
        }
    }
}