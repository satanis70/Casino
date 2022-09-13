package com.example.test.api

import com.example.test.model.statsModel.StatsModel
import com.example.test.model.tableModel.MatchesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequestStats {
    @GET("/api/data_statistic_defense.json")
    fun getDef(): Call<StatsModel>

    @GET("/api/data_statistic_attack.json")
    fun getAttack(): Call<StatsModel>
}