package com.example.test.api


import com.example.test.model.tableModel.MatchesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequestTable {
    @GET("/api/data_tournament_tables.json")
    fun getMatches(): Call<List<MatchesItem>>
}