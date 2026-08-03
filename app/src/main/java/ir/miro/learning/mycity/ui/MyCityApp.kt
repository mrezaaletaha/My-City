package ir.miro.learning.mycity.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import ir.miro.learning.mycity.R
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

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> {
            ContentType.LIST_ONLY
        }

//        WindowWidthSizeClass.Medium -> {
//            ContentType.CARD_AND_LIST
//        }

        WindowWidthSizeClass.Expanded -> {
            ContentType.FULL_SCREEN
        }

        else -> {
            ContentType.LIST_ONLY
        }
    }

    MyCityHomeScreen(
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