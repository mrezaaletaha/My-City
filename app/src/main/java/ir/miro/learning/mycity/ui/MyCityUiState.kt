package ir.miro.learning.mycity.ui

import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.Recommendation

/**
 * @author mrezaaletaha
 */

data class MyCityUiState(
    val categories: Map<Category, List<Recommendation>> = emptyMap(),
    val currentCategory: Category? = null,
    val currentSelectedRecommendation: Recommendation? = null,
) {
    val currentCategoryRecommendations: List<Recommendation> by lazy { categories[currentCategory]!! }
}