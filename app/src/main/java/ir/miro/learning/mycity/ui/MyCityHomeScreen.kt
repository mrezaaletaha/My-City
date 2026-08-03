package ir.miro.learning.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.ui.utils.ContentType

/**
 * @author mrezaaletaha
 */


@Composable
fun MyCityHomeScreen(
    contentType: ContentType,
    uiState: MyCityUiState,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
) {
    Scaffold(
        topBar = {
            MyCityAppBar()
        }
    ) { innerPadding ->
        if (contentType == ContentType.FULL_SCREEN) {
            MyCityFullScreen(
                uiState = uiState,
                onCategoryCardPressed = onCategoryCardPressed,
                onRecommendationPressed = onRecommendationPressed,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            MyCityNavigationContent(
                uiState = uiState,
                onCategoryCardPressed = onCategoryCardPressed,
                onRecommendationPressed = onRecommendationPressed,
                contentType = contentType,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

private enum class MyCityScreen {
    CATEGORY,
    RECOMMENDATION,
    DETAILS,
}

@Composable
fun MyCityNavigationContent(
    uiState: MyCityUiState,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
    contentType: ContentType,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val navController = rememberNavController()
    val startDestination =
//        if (contentType == ContentType.LIST_ONLY)
            MyCityScreen.CATEGORY.name
//        else
//            MyCityScreen.RECOMMENDATION.name

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
//        if (contentType == ContentType.LIST_ONLY) {
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
//        }
        composable(route = MyCityScreen.RECOMMENDATION.name) {
//            if (contentType == ContentType.LIST_ONLY) {
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
//            } else {
//                CardAndListContent(
//                    uiState = uiState,
//                    onCategoryCardPressed = onCategoryCardPressed,
//                    onRecommendationPressed = {
//                        onRecommendationPressed(it)
//                        navController.navigate(MyCityScreen.DETAILS.name)
//                    },
//                    contentPadding = contentPadding,
//                )
//            }
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
fun MyCityFullScreen(
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
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.medium_padding),
                bottom = contentPadding.calculateBottomPadding()
            )
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
                contentPadding = PaddingValues(bottom = dimensionResource(R.dimen.medium_padding)),
                modifier = modifier
                    .weight(2f)
                    .padding(
                        horizontal = dimensionResource(R.dimen.medium_padding),
                    ),

                ) {
                items(
                    uiState.currentCategoryRecommendations,
                    key = { recommendation -> recommendation.id }) { recommendation ->
                    RecommendationListItem(
                        recommendation,
                        onItemClick = onRecommendationPressed,
                        selected = uiState.currentSelectedRecommendation.id == recommendation.id,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            RecommendationDetailsScreen(
                selectedRecommendation = uiState.currentSelectedRecommendation,
                modifier = Modifier.weight(3f)
            )
        }
    }
}

@Composable
fun CardAndListContent(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
private fun RecommendationListItem(
    recommendation: Recommendation,
    onItemClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceContainer
        ),
        modifier = modifier,
        onClick = { onItemClick(recommendation) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            Image(
                painter = painterResource(recommendation.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.medium_padding))
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(recommendation.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(recommendation.detail),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}
