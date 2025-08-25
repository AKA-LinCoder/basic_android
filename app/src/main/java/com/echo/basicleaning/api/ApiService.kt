package com.echo.basicleaning.api

import com.echo.basicleaning.data.ApiResponse
import com.echo.basicleaning.data.News
import com.echo.basicleaning.data.TabData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("news/list")
    suspend fun getNewsList(
        @Query("category") category: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20
    ): ApiResponse<List<News>>

    @GET("tabs")
    suspend fun getTabList(): ApiResponse<List<TabData>>

    @POST("news/{id}/like")
    suspend fun likeNews(@Path("id") id: Int): ApiResponse<Boolean>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): ApiResponse<News>
}