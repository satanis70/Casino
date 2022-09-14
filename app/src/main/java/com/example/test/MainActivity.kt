package com.example.test

import android.content.Intent
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentTable = Intent(this, TableActivity::class.java)
        findViewById<Button>(R.id.buttonTable).setOnClickListener {
            startActivity(intentTable)
        }
        val intentStats = Intent(this, StatsActivity::class.java)
        findViewById<Button>(R.id.buttonStat).setOnClickListener {
            startActivity(intentStats)
        }
        val intentNews = Intent(this, NewsActivity::class.java)
        findViewById<Button>(R.id.buttonNews).setOnClickListener {
            startActivity(intentNews)
        }
        val intentSettings = Intent(this, SettingsActivity::class.java)
        findViewById<Button>(R.id.buttonSettings).setOnClickListener {
            startActivity(intentSettings)
        }



    }
}