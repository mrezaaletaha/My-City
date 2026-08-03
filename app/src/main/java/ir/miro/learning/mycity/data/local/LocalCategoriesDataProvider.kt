package ir.miro.learning.mycity.data.local


import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category

/**
 * @author mrezaaletaha
 */

object LocalCategoriesDataProvider {
    val allCategories = listOf(
        Category(
            0L,
            title = R.string.coffee_shops_title,
            img = R.drawable.coffee_shop,
        ),

        Category(
            1L,
            title = R.string.restaurants_title,
            img = R.drawable.restaurant,
        ),

        Category(
            2L,
            title = R.string.attractions_title,
            img = R.drawable.attractions,
        ),
        Category(
            3L,
            title = R.string.shopping_centers_title,
            img = R.drawable.shopping_center,
        )
    )

    val defaultCategory = allCategories[0]


    fun getCategoryById(categoryId: Long): Category {
        return allCategories.firstOrNull { it.id == categoryId }
            ?: allCategories.first()
    }
}