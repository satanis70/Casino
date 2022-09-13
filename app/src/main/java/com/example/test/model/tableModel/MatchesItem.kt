package com.example.test.model.tableModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MatchesItem(
    val name: String,
    val dates: String,
    val category: String,

    @SerializedName( "players_count")
    val playersCount: Long,

    val icon: String,
    val data: Map<String, Datum>
): Serializable