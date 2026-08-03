package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ir.miro.learning.mycity.R

/**
 * @author mrezaaletaha
 */

class Category(
    val id: Long,
    @param:StringRes val title: Int = -1,
    @param:DrawableRes val img: Int = -1,
)

//enum class CategoryType(@StringRes title: Int, @DrawableRes image: Int) {
//    COFFEE_SHOP(R.string.coffee_shops_title, R.drawable.coffee_shop),
//    RESTAURANT(R.string.restaurants_title, R.drawable.restaurant),
//    SHOPPING_CENTER(R.string.shopping_centers_title, R.drawable.shopping_center),
//    ATTRACTIONS(R.string.attractions_title, R.drawable.attractions),
//}