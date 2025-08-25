package com.echo.basicleaning.data

// ApiResponse.kt - 通用API响应格式
data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T
)

// News.kt - 示例数据模型
data class News(
    val id: Int,
    val title: String,
    val content: String,
    val publishTime: String,
    val category: String
)

// TabData.kt - Tab对应的数据
data class TabData(
    val id: String,
    val name: String,
    val apiUrl: String
)