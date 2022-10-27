package github.rnd.composestudy.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MineScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "MineScreen")
    }
}

@Preview(name = "MineScreen")
@Composable
private fun PreviewMineScreen() {
    MineScreen()
}