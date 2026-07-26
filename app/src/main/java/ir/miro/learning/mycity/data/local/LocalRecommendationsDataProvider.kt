package ir.miro.learning.mycity.data.local

import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.CategoryType
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.data.local.LocalCategoriesDataProvider.toCategory

/**
 * @author mrezaaletaha
 */

object LocalRecommendationsDataProvider {
    val allRecommendations = listOf(
        Recommendation(
            id = 0L,
            name = R.string.recommendations_coffee_shop_1,
            img = R.drawable.recommendation_coffe_shop_1,
            category = CategoryType.COFFEE_SHOP.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 1L,
            name = R.string.recommendations_coffee_shop_2,
            img = R.drawable.recommendation_coffe_shop_2,
            category = CategoryType.COFFEE_SHOP.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 2L,
            name = R.string.recommendations_coffee_shop_3,
            img = R.drawable.recommendation_coffe_shop_3,
            category = CategoryType.COFFEE_SHOP.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 3L,
            name = R.string.recommendations_coffee_shop_4,
            img = R.drawable.recommendation_coffe_shop_4,
            category = CategoryType.COFFEE_SHOP.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 4L,
            name = R.string.recommendations_coffee_shop_5,
            img = R.drawable.recommendation_coffe_shop_5,
            category = CategoryType.COFFEE_SHOP.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 5L,
            name = R.string.recommendations_restaurant_1,
            img = R.drawable.recommendation_restaurant_1,
            category = CategoryType.RESTAURANT.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 6L,
            name = R.string.recommendations_restaurant_2,
            img = R.drawable.recommendation_restaurant_2,
            category = CategoryType.RESTAURANT.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 7L,
            name = R.string.recommendations_restaurant_3,
            img = R.drawable.recommendation_restaurant_3,
            category = CategoryType.RESTAURANT.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 8L,
            name = R.string.recommendations_restaurant_4,
            img = R.drawable.recommendation_restaurant_4,
            category = CategoryType.RESTAURANT.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 9L,
            name = R.string.recommendations_restaurant_5,
            img = R.drawable.recommendation_restaurant_5,
            category = CategoryType.RESTAURANT.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 10L,
            name = R.string.recommendations_attraction_1,
            img = R.drawable.recommendation_attraction_1,
            category = CategoryType.ATTRACTIONS.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 11L,
            name = R.string.recommendations_attraction_2,
            img = R.drawable.recommendation_attraction_2,
            category = CategoryType.ATTRACTIONS.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 12L,
            name = R.string.recommendations_attraction_3,
            img = R.drawable.recommendation_attraction_3,
            category = CategoryType.ATTRACTIONS.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 13L,
            name = R.string.recommendations_attraction_4,
            img = R.drawable.recommendation_attraction_4,
            category = CategoryType.ATTRACTIONS.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 14L,
            name = R.string.recommendations_attraction_5,
            img = R.drawable.recommendation_attraction_5,
            category = CategoryType.ATTRACTIONS.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 15L,
            name = R.string.recommendations_shopping_center_1,
            img = R.drawable.recommendation_shopping_center_1,
            category = CategoryType.SHOPPING_CENTER.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 16L,
            name = R.string.recommendations_shopping_center_2,
            img = R.drawable.recommendation_shopping_center_2,
            category = CategoryType.SHOPPING_CENTER.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 17L,
            name = R.string.recommendations_shopping_center_3,
            img = R.drawable.recommendation_shopping_center_3,
            category = CategoryType.SHOPPING_CENTER.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 18L,
            name = R.string.recommendations_shopping_center_4,
            img = R.drawable.recommendation_shopping_center_4,
            category = CategoryType.SHOPPING_CENTER.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
        Recommendation(
            id = 19L,
            name = R.string.recommendations_shopping_center_5,
            img = R.drawable.recommendation_shopping_center_5,
            category = CategoryType.SHOPPING_CENTER.toCategory(),
            detail = R.string.recommendations_detail_text
        ),
    )

    fun getRecommendationById(id: Long): Recommendation {
        return allRecommendations.firstOrNull() { it.id == id }
            ?: allRecommendations.first()
    }
}