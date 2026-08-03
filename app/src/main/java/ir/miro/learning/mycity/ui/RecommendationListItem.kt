package ir.miro.learning.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import ir.miro.learning.mycity.R
import ir.miro.learning.mycity.data.Recommendation

/**
 * @author mrezaaletaha
 */

@Composable
fun RecommendationListItem(
    recommendation: Recommendation,
    onItemClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceContainer
        ),
        modifier = modifier,
        onClick = { onItemClick(recommendation) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            Image(
                painter = painterResource(recommendation.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.medium_padding))
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(recommendation.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(recommendation.detail),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}
