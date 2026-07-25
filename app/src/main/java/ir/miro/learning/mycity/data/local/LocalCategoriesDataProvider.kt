package ir.miro.learning.mycity.data.local


import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.CategoryType

/**
 * @author mrezaaletaha
 */

object LocalCategoriesDataProvider {
    val allCategories = listOf(
        Category(
            0L,
            title = R.string.restaurants_title,
            img = R.drawable.restaurant,
            type = CategoryType.RESTAURANT
        ),
        Category(
            1L,
            title = R.string.coffee_shops_title,
            img = R.drawable.coffee_shop,
            type = CategoryType.COFFEE_SHOP
        ),
        Category(
            2L,
            title = R.string.attractions_title,
            img = R.drawable.attractions,
            type = CategoryType.ATTRACTIONS
        ),
        Category(
            3L,
            title = R.string.shopping_centers_title,
            img = R.drawable.shopping_center,
            type = CategoryType.SHOPPING_CENTER
        )
    )

    fun CategoryType.toCategory() = allCategories.first() { category -> category.type == this }
}