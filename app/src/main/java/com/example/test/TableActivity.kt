package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.model.Data
import com.example.test.model.MatchItem
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.Serializable

class TableActivity : AppCompatActivity(), Serializable {

    companion object{
        const val BASE_URL = "http://84.38.181.162"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        getCurrentData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getCurrentData() {
        val russiaButton = findViewById<Button>(R.id.buttonRussia)
        val englandButton = findViewById<Button>(R.id.buttonEngland)
        val germanyButton = findViewById<Button>(R.id.buttonGermany)
        val espanaButton = findViewById<Button>(R.id.buttonEspana)
        val context = this

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
        val arrayRussia = ArrayList<MatchItem>()
        val arrayEngland = ArrayList<MatchItem>()
        val arrayGermany = ArrayList<MatchItem>()
        val arrayEspana = ArrayList<MatchItem>()
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getMatches().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                for(i in data.indices){
                    Log.i("Country", data[i].name)
                    if (data[i].name=="Россия - Премьер-Лига"){
                        arrayRussia.add(data[i])
                    }
                }
                launch(Dispatchers.Main) {
                    russiaButton.setOnClickListener {
                        val intent = Intent(context, InfoTableActivity::class.java)
                        intent.putExtra("list", arrayRussia)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}