package github.rnd.composestudy.ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import github.rnd.composestudy.ui.theme.Blue200
import github.rnd.composestudy.ui.theme.Blue700


/**
 *  统一标题栏
 */

@Composable
fun TopAppBar(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()
    
    LaunchedEffect(key1 = Unit){
        systemUiController.setStatusBarColor(Color.Transparent)
    }

    // 标题栏高度
    val appBarHeight = 56.dp

    // 转换状态栏高度 px 转为 dp
    val statusBarHeightDp = with(LocalDensity.current){
        LocalWindowInsets.current.statusBars.top.toDp()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp)
            .then(modifier)
        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ){
        content()
    }
}

@Preview(name = "TopAppBar")
@Composable
private fun PreviewTopAppBar() {
    TopAppBar(){
        Text("标题")
    }
}

/*
        备份代码 2022/10/28


@Composable
fun TopAppBar(statusBarHeight: Int,content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()

    LaunchedEffect(key1 = Unit){
        systemUiController.setStatusBarColor(Color.Transparent)
    }

    // 标题栏高度
    val appBarHeight = 56.dp

    // 转换状态栏高度 px 转为 dp
    val statusBarHeightDp = with(LocalDensity.current){
        statusBarHeight.toDp()
    }

    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp)
        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ){
        content()
    }
}

@Preview(name = "TopAppBar")
@Composable
private fun PreviewTopAppBar() {
    TopAppBar(30){
        Text("标题")
    }
}


 */