package com.example.test

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.api.ApiRequestStats
import com.example.test.api.ApiRequestTable
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class StatsActivity : AppCompatActivity() {

    companion object{
        const val BASE_URL = "http://84.38.181.162"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        getCurrentData()
    }

    @SuppressLint("ResourceAsColor")
    @OptIn(DelicateCoroutinesApi::class)
    private fun getCurrentData() {
        val buttonDef = findViewById<AppCompatButton>(R.id.buttonDefence)
        val buttonAttack = findViewById<AppCompatButton>(R.id.buttonAttack)
        val context = this

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequestStats::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getDef().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                Log.i("stats", data.toString())

                launch(Dispatchers.Main) {
                    val adapter = HolderStats(data)
                    val recyclerViewTable = findViewById<RecyclerView>(R.id.recycler_view_stats)
                    recyclerViewTable.layoutManager = LinearLayoutManager(context)
                    recyclerViewTable.adapter = adapter
                }
            }
        }

        buttonDef.setOnClickListener {
            buttonAttack.setBackgroundResource(R.drawable.roundedbuttoninactive)
            buttonDef.setBackgroundResource(R.drawable.roundedbutton)
            GlobalScope.launch(Dispatchers.IO) {
                val response = api.getDef().awaitResponse()
                if (response.isSuccessful){
                    val data = response.body()!!
                    Log.i("stats", data.toString())

                    launch(Dispatchers.Main) {
                        val adapter = HolderStats(data)
                        val recyclerViewTable = findViewById<RecyclerView>(R.id.recycler_view_stats)
                        recyclerViewTable.layoutManager = LinearLayoutManager(context)
                        recyclerViewTable.adapter = adapter
                    }
                }
            }
        }
        buttonAttack.setOnClickListener {
            buttonAttack.setBackgroundResource(R.drawable.roundedbutton)
            buttonDef.setBackgroundResource(R.drawable.roundedbuttoninactive)
            GlobalScope.launch(Dispatchers.IO) {
                val response = api.getAttack().awaitResponse()
                if (response.isSuccessful){
                    val data = response.body()!!
                    Log.i("stats", data.toString())

                    launch(Dispatchers.Main) {
                        val adapter = HolderStats(data)
                        val recyclerViewTable = findViewById<RecyclerView>(R.id.recycler_view_stats)
                        recyclerViewTable.layoutManager = LinearLayoutManager(context)
                        recyclerViewTable.adapter = adapter
                    }
                }
            }
        }

    }
}