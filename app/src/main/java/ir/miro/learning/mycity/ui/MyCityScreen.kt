package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.local.LocalCategoriesDataProvider
import ir.miro.learning.mycity.data.local.LocalRecommendationsDataProvider

/**
 * @author mrezaaletaha
 */

private enum class MyCityScreen {
    CATEGORY,
    RECOMMENDATION,
    DETAILS,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) }
    )
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            MyCityAppBar()
        }
    ) { innerPadding ->
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
                RecommendationsListScreen(
                    recommendations = LocalRecommendationsDataProvider.allRecommendations,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            composable(route = MyCityScreen.DETAILS.name) {

            }
        }
    }
}