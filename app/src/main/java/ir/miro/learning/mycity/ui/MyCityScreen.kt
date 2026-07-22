package ir.miro.learning.mycity.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * @author mrezaaletaha
 */

enum class MyCityScreen {
    CATEGORY,
    RECOMMENDATION,
    DETAILS,
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MyCityScreen.CATEGORY.name
    ) {
        composable(route = MyCityScreen.CATEGORY.name) {

        }
        composable(route = MyCityScreen.RECOMMENDATION.name) {

        }
        composable(route = MyCityScreen.DETAILS.name) {

        }
    }
}