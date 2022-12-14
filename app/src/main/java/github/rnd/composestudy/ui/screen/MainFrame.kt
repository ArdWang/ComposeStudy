package github.rnd.composestudy.ui.screen

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import github.rnd.composestudy.model.entity.NavigationItem


/**
 * created by ArdWang 2022/10/27:3:18 下午
 */

@Composable
fun MainFrame(){

    val navigationItems = listOf(
        NavigationItem(title = "学习", icon = Icons.Filled.Home),
        NavigationItem(title = "任务", icon = Icons.Filled.DateRange),
        NavigationItem(title = "我的", icon = Icons.Filled.Person)
    )

    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }

    ProvideWindowInsets {
        Scaffold(bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.navigationBarsPadding(bottom = true)
            ) {
                navigationItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationItem(
                        selected = currentNavigationIndex == index,
                        onClick = {
                            // 写点击事件
                            currentNavigationIndex = index
                        },icon = {
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = null)
                        }, label = {
                            Text(text = navigationItem.title)
                        }, selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF999999))
                }
            }
        }) {

            when (currentNavigationIndex) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }


        }

    }
    
}


@Preview
@Composable
fun MainFramePreview(){
    MainFrame()
}