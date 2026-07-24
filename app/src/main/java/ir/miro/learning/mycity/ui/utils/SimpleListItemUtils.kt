package ir.miro.learning.mycity.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ir.miro.learning.mycity.data.CategoryType
import ir.miro.learning.mycity.data.Recommendation

/**
 * @author mrezaaletaha
 */

data class SimpleListItem(
    @StringRes val nameResId: Int,
    @DrawableRes val imgResId: Int,
)

fun CategoryType.toListItem() = SimpleListItem(nameResId = title, imgResId = img)
fun Recommendation.toListItem() = SimpleListItem(nameResId = name, imgResId = img)