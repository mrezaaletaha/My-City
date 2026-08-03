package ir.miro.learning.mycity.ui

import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.data.local.LocalCategoriesDataProvider
import ir.miro.learning.mycity.data.local.LocalRecommendationsDataProvider

/**
 * @author mrezaaletaha
 */

data class MyCityUiState(
    val categories: Map<Category, List<Recommendation>> = emptyMap(),
    val currentCategory: Category = LocalCategoriesDataProvider.defaultCategory,
    val currentSelectedRecommendation: Recommendation = LocalRecommendationsDataProvider.defaultRecommendation,
) {
    val currentCategoryRecommendations: List<Recommendation> by lazy { categories[currentCategory]!! }
}