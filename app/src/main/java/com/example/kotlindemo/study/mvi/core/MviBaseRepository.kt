package com.example.kotlindemo.study.mvi.core

import com.zhaopin.social.module_common_util.log.LogKitty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @Description
 * @Author LuoJia
 * @Date 2023/12/2
 */
abstract class MviBaseRepository<Event : IUiEvent>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main,
) {

    /** 协程 */
    protected val scope by lazy { CoroutineScope(SupervisorJob() + dispatcher + exceptionHandler) }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        LogKitty.e("MviBaseRepository", throwable)
    }

    /** repo发送的消息，viewModel接受 */
    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    /**
     * 发送Event
     */
    protected fun setEvent(event: Event) {
        scope.launch(exceptionHandler) {
            _eventFlow.emit(event)
        }
    }


}