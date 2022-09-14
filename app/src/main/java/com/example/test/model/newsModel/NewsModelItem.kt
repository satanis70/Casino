package com.example.test.model.newsModel


import com.google.gson.annotations.SerializedName

data class NewsModelItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("tittle")
    val tittle: String
)