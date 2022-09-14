package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.api.ApiRequestNews
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsActivity : AppCompatActivity() {

    companion object{
        const val BASE_URL = "http://84.38.181.162"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        getCurrentData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getCurrentData() {
        val context = this
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequestNews::class.java)

        GlobalScope.launch(Dispatchers.IO){
            val response = api.getNews().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                Log.i("news", data.toString())

                launch(Dispatchers.Main) {
                    val adapter = HolderNews(data)
                    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_news)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter
                }
            }
        }

    }
}