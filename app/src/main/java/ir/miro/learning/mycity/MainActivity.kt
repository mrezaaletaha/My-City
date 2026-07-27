package ir.miro.learning.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.miro.learning.mycity.ui.MyCityApp
import ir.miro.learning.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyCityApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyCityAppCompactPreview() {
    MyCityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyCityApp()
        }
    }
}

@Preview(widthDp = 700)
@Composable
fun MyCityAppMediumPreview() {
    MyCityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyCityApp()
        }
    }
}

@Preview(widthDp = 1000)
@Composable
fun MyCityAppExpandedPreview() {
    MyCityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyCityApp()
        }
    }
}