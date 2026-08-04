package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @author mrezaaletaha
 */

class Category(
    val id: Long,
    @param:StringRes val title: Int = -1,
    @param:DrawableRes val img: Int = -1,
)
