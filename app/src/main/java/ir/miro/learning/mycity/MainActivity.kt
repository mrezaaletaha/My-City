package ir.miro.learning.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.miro.learning.mycity.ui.MyCityApp
import ir.miro.learning.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    MyCityApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun MyCityAppCompactPreview() {
    MyCityTheme {
        Surface {
            MyCityApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

@Preview(widthDp = 700)
@Composable
fun MyCityAppMediumPreview() {
    MyCityTheme {
        Surface {
            MyCityApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
    }
}

@Preview(widthDp = 1000)
@Composable
fun MyCityAppExpandedPreview() {
    Surface {
        MyCityTheme {
            MyCityApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
    }
}