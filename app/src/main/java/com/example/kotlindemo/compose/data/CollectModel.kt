package com.example.kotlindemo.compose.data

import androidx.compose.ui.graphics.Color
import com.zhaopin.social.compose.ui.ZlColor

/**
 * @Description
 * @Author LuoJia
 * @Date 2023/12/15
 */
data class CollectJobState(
    val list: List<CollectJobItem>
)

data class CollectJobItem(
    val isOffline: Boolean,
    val offlineColor: Color = ZlColor.C_B3,
    val onlineColor: Color = ZlColor.C_B2,
    val jobName: String,
    val jobNameColor: Color = ZlColor.C_B1,
    val firstTagUrl: String = "",
    val secondTagUrl: String = "",
    val salary: String,
    val salaryColor: Color = ZlColor.C_P1,
    val companyName: String,
    val companyStrength: String,
    val companySize: String,
    val skillList: List<String>,
    val hrAvatar: String,
    val hrOnline: Boolean,
    val hrName: String,
    val publishDate: String
)

data class CollectCompanyState(
    val list: List<CollectCompanyItem>
)

data class CollectCompanyItem(
    val companyName: String,
    val companyIcon: String,
    val companyProperty: String,
    val companySize: String,
    val industry: String,
    val address: String
)