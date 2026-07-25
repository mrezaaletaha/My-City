package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @author mrezaaletaha
 */

class Category (
    val id: Long,
    @param:StringRes val title: Int,
    @param:DrawableRes val img: Int,
    val type: CategoryType,
)

enum class CategoryType {
    COFFEE_SHOP,
    RESTAURANT,
    SHOPPING_CENTER,
    ATTRACTIONS,
}