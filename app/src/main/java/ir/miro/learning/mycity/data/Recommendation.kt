package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @author mrezaaletaha
 */

data class Recommendation(
    val id: Long,
    val category: Category,
    @DrawableRes val img: Int,
    @StringRes val name: Int,
    @StringRes val detail: Int,
)