package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.ui.utils.ContentType
import ir.miro.learning.mycity.ui.utils.MyCityScreen

/**
 * @author mrezaaletaha
 */


@Composable
fun MyCityNavigationContent(
    uiState: MyCityUiState,
    navController: NavHostController,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    contentType: ContentType,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    var startDestination by rememberSaveable { mutableStateOf("") }

    startDestination = if (uiState.isShowingListPage) {
        MyCityScreen.CATEGORY.name
    } else {
        MyCityScreen.RECOMMENDATION.name
    }
    NavigationListOnlyContent(
        uiState = uiState,
        navController = navController,
        contentType = contentType,
        startDestination = startDestination,
        onCategoryCardPressed = onCategoryCardPressed,
        onRecommendationPressed = onRecommendationPressed,
        modifier = modifier,
        contentPadding = contentPadding,
    )
}

@Composable
private fun NavigationListOnlyContent(
    uiState: MyCityUiState,
    navController: NavHostController,
    contentType: ContentType,
    startDestination: String,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,//MyCityScreen.CATEGORY.name,
        modifier = modifier,
    ) {
        composable(route = MyCityScreen.CATEGORY.name) {
            CategoriesListScreen(
                categories = uiState.categories.keys.toList(),
                onCategoryCardPressed = {
                    onCategoryCardPressed(it)
                    navController.navigate(route = MyCityScreen.RECOMMENDATION.name)
                },
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(contentPadding)
            )
        }
        composable(route = MyCityScreen.RECOMMENDATION.name) {
            if (contentType == ContentType.LIST_ONLY) {
                RecommendationsList(
                    recommendations = uiState.currentCategoryRecommendations,
                    onRecommendationPressed = {
                        onRecommendationPressed(it)
                        navController.navigate(MyCityScreen.DETAILS.name)
                    },
                    contentPadding = PaddingValues(dimensionResource(R.dimen.medium_padding)),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding)
                )
            } else {
                CardAndListContent(
                    uiState = uiState,
                    onCategoryCardPressed = onCategoryCardPressed,
                    onRecommendationPressed = {
                        onRecommendationPressed(it)
                        navController.navigate(MyCityScreen.DETAILS.name)
                    },
                    contentPadding = contentPadding,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        composable(route = MyCityScreen.DETAILS.name) {
            RecommendationDetailsScreen(
                selectedRecommendation = uiState.currentSelectedRecommendation,
                contentPadding = contentPadding,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
private fun CardAndListContent(
    uiState: MyCityUiState,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(modifier = modifier) {
        CategoriesListHorizontal(
            uiState = uiState,
            onCategoryCardPressed = onCategoryCardPressed,
            contentPadding = contentPadding,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.small_padding),
                )
        )
        RecommendationsList(
            recommendations = uiState.currentCategoryRecommendations,
            onRecommendationPressed = onRecommendationPressed,
            contentPadding = PaddingValues(vertical = dimensionResource(R.dimen.medium_padding)),
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding),
                bottom = contentPadding.calculateBottomPadding()
            )
        )
    }
}

@Composable
fun RecommendationsList(
    recommendations: List<Recommendation>,
    onRecommendationPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        contentPadding = contentPadding,
        modifier = modifier,

        ) {
        items(recommendations, key = { recommendation -> recommendation.id }) { recommendation ->
            RecommendationListItem(
                recommendation,
                onItemClick = onRecommendationPressed,
                selected = false,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
