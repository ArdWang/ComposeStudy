package github.rnd.composestudy.model.entity


import androidx.compose.ui.graphics.vector.ImageVector

/**
 * created by ArdWang 2022/10/27:3:22 下午
 */

/**
 * 导航栏对象
 */
data class NavigationItem(
    val title:String, // 底部导航栏的标题
    val icon:ImageVector // 底部导航栏图标
)
