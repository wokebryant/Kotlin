package com.example.kotlindemo.data

import com.example.kotlindemo.R
import com.example.kotlindemo.activity.MaterialDesignActivity
import com.example.kotlindemo.model.MainItemState
import com.example.kotlindemo.model.MainItemType

/**
 * @Description
 * @Author LuoJia
 * @Date 2023/10/17
 */

val mainItemList = mutableListOf(
    MainItemState(
        title = "Material示例",
        type = MainItemType.Material
    ),
    MainItemState(
        title = "MotionLayout示例",
        type = MainItemType.Motion
    ),
    MainItemState(
        title = "ConstrainLayout示例",
        type = MainItemType.Constraint
    ),
    MainItemState(
        title = "ViewPager2示例",
        type = MainItemType.ViewPager2
    ),
    MainItemState(
        title = "Mark测试",
        type = MainItemType.Mark
    ),
    MainItemState(
        title = "区块链钱包",
        type = MainItemType.BlockChain
    ),
    MainItemState(
        title = "Flow",
        type = MainItemType.Flow
    ),
    MainItemState(
        title = "富文本",
        type = MainItemType.Span
    ),
    MainItemState(
        title = "MVI",
        type = MainItemType.MVI
    ),
    MainItemState(
        title = "Compose通用状态页",
        type = MainItemType.ComposeStateLayout
    ),
    MainItemState(
        title = "Compose分页库",
        type = MainItemType.ComposePaging
    ),
    MainItemState(
        title = "智联需求",
        type = MainItemType.ZLTask,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P1
    ),
    MainItemState(
        title = "AppBar",
        type = MainItemType.AppBar,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "二级联动",
        type = MainItemType.Linkage,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "小微企业",
        type = MainItemType.MircoCompany,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "搜索桥",
        type = MainItemType.SearchBridge,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "搜索结果页",
        type = MainItemType.SearchResult,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "职位详情页",
        type = MainItemType.JobDetail,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "职位排行榜",
        type = MainItemType.PositionRank,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "收藏页Compose",
        type = MainItemType.CollectCompose,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "Ai求职",
        type = MainItemType.AiRecommend,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "简历推荐",
        type = MainItemType.ResumeRecommend,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "发送微信",
        type = MainItemType.WechatSend,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "蓝领简历编辑",
        type = MainItemType.BlueResumeEdit,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "登录验证",
        type = MainItemType.LoginAuth,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "登录邮箱验证",
        type = MainItemType.LoginAuthMail,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
    MainItemState(
        title = "绑定手机号验证",
        type = MainItemType.LoginCheckBindPhone,
        textColor = R.color.C_W1,
        bgColor = R.color.C_P3
    ),
)