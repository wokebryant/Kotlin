package com.example.kotlindemo.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.kotlindemo.compose.ui.ZlColors
import com.example.kotlindemo.compose.widget.refresh.footer.LoadFooter
import com.zhaopin.social.appbase.util.curContext
import com.zhaopin.social.appbase.util.currentActivity
import com.zhaopin.toast.showToast

@Composable
fun LoadMoreLazyColum(
    listSize: Int,
    loadState: CombinedLoadStates,
    modifier: Modifier = Modifier,
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        content()
        // 刷新
        when (loadState.refresh) {
            // 展示加载状态
            is LoadState.Loading -> {
                if (listSize == 0) {
                    item {
                        Box(modifier = Modifier.fillParentMaxSize()) {
                            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
                        }
                    }
                }
            }

            // 展示错误页面
            is LoadState.Error -> {

            }
            // 展示空页面
            is LoadState.NotLoading -> {
                if (listSize == 0) {
                    item {

                    }
                }
            }
        }

        // 加载更多
        when (loadState.append) {
            // 加载中
            is LoadState.Loading -> {
                item {
                    LoadFooter(loadState = loadState.append)
                }
            }
            // 加载失败
            is LoadState.Error -> {}
            // 加载完成
            is LoadState.NotLoading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "已经到底咯～",
                            style = TextStyle(
                                fontSize =  13.sp,
                                color = ZlColors.C_B1B7BE
                            )
                        )
                    }
                }
            }
        }
    }
}