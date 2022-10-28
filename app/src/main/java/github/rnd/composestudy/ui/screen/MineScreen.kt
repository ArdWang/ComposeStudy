package github.rnd.composestudy.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import github.rnd.composestudy.ui.component.TopAppBar

@Composable
fun MineScreen(

) {
    Column(modifier = Modifier) {

        Text("学习页")

    }
}

@Preview(name = "MineScreen")
@Composable
private fun PreviewMineScreen() {
    MineScreen()
}