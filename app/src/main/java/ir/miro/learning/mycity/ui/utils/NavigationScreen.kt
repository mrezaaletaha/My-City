package ir.miro.learning.mycity.ui.utils

import androidx.annotation.StringRes
import ir.miro.learning.mycity.R

/**
 * @author mrezaaletaha
 */

enum class MyCityScreen(@StringRes val title: Int) {
    CATEGORY(R.string.app_name),
    RECOMMENDATION(R.string.recommendations_title),
    DETAILS(R.string.details_title),
}