package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.miro.learning.mycity.R

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
    val viewModel: MyCityViewModel = viewModel()

    Scaffold(
        topBar = {
            MyCityAppBar()
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = MyCityScreen.CATEGORY.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.CATEGORY.name) {
                CategoriesListScreen(
                    categories = uiState.categories.keys.toList(),
                    onCategoryCardPressed = {
                        viewModel.updateRecommendationsScreenStates(it)
                        navController.navigate(route = MyCityScreen.RECOMMENDATION.name)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )
            }
            composable(route = MyCityScreen.RECOMMENDATION.name) {
                RecommendationsListScreen(
                    recommendations = uiState.currentCategoryRecommendations,
                    onRecommendationClick = {
                        viewModel.updateDetailsScreenStates(it)
                        navController.navigate(MyCityScreen.DETAILS.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            composable(route = MyCityScreen.DETAILS.name) {
                RecommendationDetailsScreen(
                    selectedRecommendation = uiState.currentSelectedRecommendation
                        ?: uiState.currentCategoryRecommendations.first(),
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}