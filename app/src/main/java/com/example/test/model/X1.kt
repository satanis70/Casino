package com.example.test.model


import com.google.gson.annotations.SerializedName

data class X1(
    @SerializedName("В")
    val v: Int,
    @SerializedName("Игры")
    val games: Int,
    @SerializedName("Команда")
    val team: String,
    @SerializedName("Мячи")
    val balls: String,
    @SerializedName("Н")
    val n: Int,
    @SerializedName("Очки")
    val points: Int,
    @SerializedName("% очков")
    val pointsPercentage: String,
    @SerializedName("П")
    val p: Int
)