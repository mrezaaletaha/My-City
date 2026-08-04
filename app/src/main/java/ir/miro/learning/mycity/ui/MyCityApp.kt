package ir.miro.learning.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.miro.learning.mycity.ui.utils.ContentType

/**
 * @author mrezaaletaha
 */

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
) {
    val viewModel: MyCityViewModel = viewModel()
    val myCityUiState by viewModel.uiState.collectAsState()

    val contentType: ContentType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.LIST_ONLY
            viewModel.updateShowingListPageState(true)
        }

        WindowWidthSizeClass.Medium -> {
            contentType = ContentType.CARD_AND_LIST
            viewModel.updateShowingListPageState(false)
        }

        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.FULL_SCREEN
        }

        else -> {
            contentType = ContentType.LIST_ONLY
            viewModel.updateShowingListPageState(true)
        }
    }

    MyCityHomeContent(
        contentType = contentType,
        uiState = myCityUiState,
        onCategoryCardPressed = { category ->
            viewModel.updateRecommendationsScreenStates(category)
        },
        onRecommendationPressed = { recommendation ->
            viewModel.updateDetailsScreenStates(recommendation)
        },
    )
}