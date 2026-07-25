package ir.miro.learning.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.data.local.LocalRecommendationsDataProvider

/**
 * @author mrezaaletaha
 */

@Composable
fun RecommendationsListScreen(
    recommendations: List<Recommendation>,
    onRecommendationClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
        modifier = modifier,

        ) {
        items(recommendations) { recommendation ->
            RecommendationListItem(
                recommendation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.medium_padding))
                    .clickable(
                        onClick = { onRecommendationClick(recommendation) }
                    )
            )
        }
    }
}

@Composable
private fun RecommendationListItem(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(recommendation.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.recommendation_list_item_image_size))
                    .clip(
                        RoundedCornerShape(
                            dimensionResource(R.dimen.recommendation_list_item_image_corner_radius)
                        )
                    )
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.small_padding)))
            Column {
                Text(
                    text = stringResource(recommendation.name)
                )
            }
        }
        HorizontalDivider(
            thickness = dimensionResource(R.dimen.thickness_divider),
        )
    }
}

@Preview
@Composable
fun RecommendationsListScreenPreview() {
    RecommendationsListScreen(
        recommendations = LocalRecommendationsDataProvider.allRecommendations,
        onRecommendationClick = {}
    )
}