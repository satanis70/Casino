package com.example.test.api

import com.example.test.model.newsModel.NewsModel
import com.example.test.model.tableModel.MatchesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequestNews {
    @GET("/api/news.json")
    fun getNews(): Call<NewsModel>
}