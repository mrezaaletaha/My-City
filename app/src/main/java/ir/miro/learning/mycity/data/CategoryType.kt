package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ir.miro.learning.mycity.R

/**
 * @author mrezaaletaha
 */

enum class CategoryType(
    @param:StringRes val title: Int,
    @param:DrawableRes val img: Int,
) {
    COFFEE_SHOP(
        R.string.coffee_shops_title,
        R.drawable.coffee_shop
    ),
    RESTAURANT(
        R.string.restaurants_title,
        R.drawable.restaurant
    ),
    SHOPPING_CENTER(
        R.string.shopping_centers_title,
        R.drawable.shopping_center
    ),
    ATTRACTIONS(
        R.string.attractions_title,
        R.drawable.attractions
    ),
}