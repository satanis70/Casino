package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.test.api.ApiRequestTable
import com.example.test.model.tableModel.Datum
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
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
            .create(ApiRequestTable::class.java)

        val arrayEngland = ArrayList<Datum>()
        val arrayGermany = ArrayList<Datum>()
        val arrayEspana = ArrayList<Datum>()
        val arrayRussia = ArrayList<Datum>()
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getMatches().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                //Log.i("country", data.toString())
                for (i in data[0].data.values){
                    arrayEngland.add(i)
                }
                for (i in data[1].data.values){
                    arrayRussia.add(i)
                }
                for (i in data[2].data.values){
                    arrayEspana.add(i)
                }
                for (i in data[3].data.values){
                    arrayGermany.add(i)
                }

                launch(Dispatchers.Main) {
                    russiaButton.setOnClickListener {
                        val intent = Intent(context, InfoTableActivity::class.java)
                        intent.putExtra("list", arrayRussia)
                        startActivity(intent)
                    }
                    englandButton.setOnClickListener {
                        val intent = Intent(context, InfoTableActivity::class.java)
                        intent.putExtra("list", arrayEngland)
                        startActivity(intent)
                    }
                    espanaButton.setOnClickListener {
                        val intent = Intent(context, InfoTableActivity::class.java)
                        intent.putExtra("list", arrayEspana)
                        startActivity(intent)
                    }
                    germanyButton.setOnClickListener {
                        val intent = Intent(context, InfoTableActivity::class.java)
                        intent.putExtra("list", arrayGermany)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}