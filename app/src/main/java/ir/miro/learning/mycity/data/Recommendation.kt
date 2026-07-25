package ir.miro.learning.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @author mrezaaletaha
 */

data class Recommendation(
    val id: Long,
    @StringRes val name: Int,
    @DrawableRes val img: Int,
    val category: Category,
)