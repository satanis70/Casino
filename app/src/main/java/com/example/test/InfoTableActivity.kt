package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.model.tableModel.Datum
import java.io.Serializable

class InfoTableActivity : AppCompatActivity(), Serializable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_table)
        val intent = intent
        val array: ArrayList<Datum> = intent.getSerializableExtra("list") as ArrayList<Datum>
        Log.i("x1", array.toString())
        val adapter = HolderTable(array)
        val recyclerViewTable = findViewById<RecyclerView>(R.id.recycler_view_table)
        recyclerViewTable.layoutManager = LinearLayoutManager(this)
        recyclerViewTable.adapter = adapter
    }
}