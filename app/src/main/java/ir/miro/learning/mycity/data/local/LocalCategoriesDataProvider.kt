package ir.miro.learning.mycity.data.local


import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.CategoryType
import ir.miro.learning.mycity.ui.utils.SimpleListItem
import ir.miro.learning.mycity.ui.utils.toListItem

/**
 * @author mrezaaletaha
 */

object LocalCategoriesDataProvider {
    val allCategories = listOf(
        CategoryType.RESTAURANT.toListItem(),
        CategoryType.COFFEE_SHOP.toListItem(),
        CategoryType.ATTRACTIONS.toListItem(),
        CategoryType.SHOPPING_CENTER.toListItem(),
    )
}