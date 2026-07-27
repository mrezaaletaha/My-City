package ir.miro.learning.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Category
import ir.miro.learning.mycity.data.local.LocalCategoriesDataProvider

/**
 * @author mrezaaletaha
 */

@Composable
fun CategoriesListScreen(
    categories: List<Category>,
    onCategoryCardPressed: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.medium_padding),
            )
        ) {
            categories.forEach { category ->
                CategoryListItem(
                    category = category,
                    onCardClick = { onCategoryCardPressed(category) },
                )
            }
        }
    }
}

@Composable
fun CategoryListItem(
    category: Category,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = onCardClick,
    ) {
        Box {
            Image(
                painter = painterResource(category.img),
                contentDescription = stringResource(category.title),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
            )
            Text(
                text = stringResource(category.title),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .alpha(0.8f)
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
        ) {

        }
    }
}

@Preview
@Composable
fun CategoriesListScreenPreview() {
    CategoriesListScreen(
        categories = LocalCategoriesDataProvider.allCategories,
        modifier = Modifier.verticalScroll(rememberScrollState()),
        onCategoryCardPressed = {}
    )
}