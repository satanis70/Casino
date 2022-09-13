package com.example.test.model.statsModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StatsModelItem(
    @SerializedName("Команда")
    val team: String,
    @SerializedName("Отборы з.и.")
    val selections: Double,
    @SerializedName("Офсайды з.и.")
    val offsides: Double,
    @SerializedName("Перехваты з.и.")
    val interceptions: Double,
    @SerializedName("Рейтинг")
    val rating: Double,
    @SerializedName("Турнир")
    val tournament: String,
    @SerializedName("Удары з.и.")
    val kicks: Double,
    @SerializedName("Фолы з.и.")
    val fouls: Double
): Serializable