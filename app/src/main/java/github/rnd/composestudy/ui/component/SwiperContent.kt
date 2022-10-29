package github.rnd.composestudy.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import github.rnd.composestudy.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import java.util.*

/**
 * author ardwang created time 2022/10/29 3:56 PM
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwiperContent(vm:MainViewModel){

    // 虚拟页数
    val virtualCount = Int.MAX_VALUE

    // 实际页数
    val actualCount = vm.swiperData.size

    // 初始图片下标
    val initialIndex = virtualCount / 2

    val pageState = rememberPagerState(initialPage = initialIndex)

    val coroutineScope = rememberCoroutineScope()

    // 自动定时器
    DisposableEffect(Unit){
        val timer = Timer()
        timer.schedule(object :TimerTask(){
            override fun run() {
                coroutineScope.launch {
                    pageState.animateScrollToPage(pageState.currentPage+1)
                }
            }

        },3000,3000)
        onDispose {
            timer.cancel()
        }
    }

    // 轮播图
    HorizontalPager(
        count = virtualCount,
        state = pageState,
        //contentPadding = PaddingValues(16.dp)
        //itemSpacing = 16.dp
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ){ index ->

        val actualIndex = (index - initialIndex).floorMod(actualCount) //index - (index.floorDiv(actualCount)) * actualCount

        AsyncImage(
            model = vm.swiperData[actualIndex].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 3f),
            contentScale = ContentScale.Crop
        )
    }
}


private fun Int.floorMod(other:Int):Int = when(other){
    0 -> this
    else -> this - floorDiv(other) * other
}

