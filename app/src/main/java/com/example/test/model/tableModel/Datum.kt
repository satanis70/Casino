package com.example.test.model.tableModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Datum (
    @SerializedName("Команда")
    val team: String,

    @SerializedName("Игры")
    val games: Long,

    @SerializedName("В")
    val v: Long,

    @SerializedName("Н")
    val n: Long,

    @SerializedName("П")
    val p: Long,

    @SerializedName("Мячи")
    val balls: String,

    @SerializedName("Очки")
    val points: Long,

    @SerializedName("% очков")
    val percent: String
):Serializable