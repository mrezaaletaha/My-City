package ir.miro.learning.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Recommendation
import ir.miro.learning.mycity.data.local.LocalRecommendationsDataProvider

/**
 * @author mrezaaletaha
 */

@Composable
fun RecommendationDetailsScreen(
    selectedRecommendation: Recommendation,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Column() {
            Box {
                Image(
                    painter = painterResource(selectedRecommendation.img),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .alpha(0.75F)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.surfaceContainer
                                ),
                                startY = 0F,
                                endY = 50F
                            )
                        )
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.small_padding))
                ) {
                    Text(
                        text = stringResource(selectedRecommendation.name),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 2,
                        modifier = Modifier.weight(1F)
                    )
                    Text(
                        text = stringResource(selectedRecommendation.category.title),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface,
//                        modifier = Modifier.weight(1F)
                    )
                }
            }
            Text(
                text = stringResource(selectedRecommendation.detail),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
        }
    }
}


@Preview
@Composable
fun RecommendationDetailsScreenPreview() {
    RecommendationDetailsScreen(
        selectedRecommendation = LocalRecommendationsDataProvider.allRecommendations.first()
    )
}