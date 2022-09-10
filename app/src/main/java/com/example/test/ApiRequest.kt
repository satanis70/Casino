package com.example.test


import com.example.test.model.Matches
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {
    @GET("/api/data_tournament_tables.json")
    fun getMatches(): Call<Matches>
}