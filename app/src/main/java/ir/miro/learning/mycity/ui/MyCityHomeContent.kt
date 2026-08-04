package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.test.arrow_back
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.ui.utils.ContentType
import ir.miro.learning.mycity.ui.utils.MyCityScreen

/**
 * @author mrezaaletaha
 */


@Composable
fun MyCityHomeContent(
    contentType: ContentType,
    uiState: MyCityUiState,
    onCategoryCardPressed: (Category) -> Unit,
    onRecommendationPressed: (Recommendation) -> Unit,
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.CATEGORY.name
    )

    Scaffold(
        topBar = {
            MyCityAppBar(
                title = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {navController.navigateUp()}
            )
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
                navController = navController,
                onCategoryCardPressed = onCategoryCardPressed,
                onRecommendationPressed = onRecommendationPressed,
                contentType = contentType,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    title: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(title),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = arrow_back,
                        contentDescription = stringResource(R.string.back_button),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}
