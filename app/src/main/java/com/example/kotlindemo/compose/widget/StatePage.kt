package com.example.kotlindemo.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.kotlindemo.R
import com.example.kotlindemo.compose.widget.stateLayout.state.EmptyState
import com.example.kotlindemo.compose.widget.stateLayout.state.ErrorState
import com.example.kotlindemo.compose.widget.stateLayout.state.defaultErrorState
import com.zhaopin.social.compose.ui.ZlColor

/**
 * @Description 页面状态
 * @Author LuoJia
 * @Date 2023/12/18
 */

@Composable
fun <T : Any> Paging3StatePage(
    pagingItems: LazyPagingItems<T>,
    empty: EmptyState,
    error: ErrorState = defaultErrorState
) {
    when (pagingItems.loadState.refresh) {
        // 展示加载状态
        is LoadState.Loading -> {
            if (pagingItems.itemCount == 0) {
                RefreshLoadingPage()
            }
        }

        // 展示错误页面
        is LoadState.Error -> {
            RefreshErrorPage(error) {
                pagingItems.retry()
            }
        }
        // 展示空页面
        is LoadState.NotLoading -> {
            if (pagingItems.itemCount == 0) {
                RefreshEmptyPage(empty)
            }
        }
    }
}

@Composable
fun RefreshLoadingPage() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(ZlColor.C_W1)) {
        CircularProgressIndicator(
            modifier = Modifier.align(alignment = Alignment.Center),
            color = ZlColor.C_P1
        )
    }
}

@Composable
fun RefreshEmptyPage(
    empty: EmptyState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ZlColor.C_W1),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.b_common_b_app_no_data_icon),
                contentDescription = "",
                modifier = Modifier.size(width = 200.dp, height = 150.dp)
            )
            Text(
                text = empty.emptyTip,
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 16.dp, start = 56.dp, end = 56.dp)
            )
        }
    }
}

@Composable
fun RefreshErrorPage(
    error: ErrorState,
    retry: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ZlColor.C_W1),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.b_common_b_app_no_data_icon),
                contentDescription = "",
                modifier = Modifier.size(width = 200.dp, height = 150.dp)
            )
            Text(
                text = error.errorTip,
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 16.dp, start = 56.dp, end = 56.dp)
            )
            TextButton(
                onClick = { retry() },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = ZlColor.C_W1,
                    backgroundColor = ZlColor.C_P1
                ),
                modifier = Modifier.padding(top = 20.dp).width(84.dp).height(36.dp)
            ) {
                Text(
                    text = "重试",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}