package ir.miro.learning.mycity.ui

import androidx.lifecycle.ViewModel
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.data.local.LocalRecommendationsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * @author mrezaaletaha
 */

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val categories: Map<Category, List<Recommendation>> = LocalRecommendationsDataProvider
            .allRecommendations.groupBy { it.category }
        _uiState.value =
            MyCityUiState(
                categories = categories
            )
    }

    fun updateRecommendationsScreenStates(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category,
                currentSelectedRecommendation = _uiState.value.categories[category]?.first()
                    ?: LocalRecommendationsDataProvider.defaultRecommendation
            )
        }
    }

    fun updateDetailsScreenStates(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation
            )
        }
    }

    fun updateShowingListPageState(isShowingListPage: Boolean) {
        _uiState.update {
            it.copy(
                isShowingListPage = isShowingListPage,
            )
        }
    }
}