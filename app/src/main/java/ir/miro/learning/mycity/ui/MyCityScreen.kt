package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.miro.learning.mycity.data.local.LocalCategoriesDataProvider

/**
 * @author mrezaaletaha
 */

private enum class MyCityScreen {
    CATEGORY,
    RECOMMENDATION,
    DETAILS,
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityScreen.CATEGORY.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.CATEGORY.name) {
                CategoriesListScreen(
                    categories = LocalCategoriesDataProvider.allCategories,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )
            }
            composable(route = MyCityScreen.RECOMMENDATION.name) {

            }
            composable(route = MyCityScreen.DETAILS.name) {

            }
        }
    }
}