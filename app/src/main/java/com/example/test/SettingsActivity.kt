package com.example.test

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        findViewById<SwitchCompat>(R.id.switch_theme).setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        val array = ArrayList<Int>()
        array.add(R.drawable.splash)
        array.add(R.drawable.splash2)
        array.add(R.drawable.splash3)

        findViewById<AppCompatButton>(R.id.button_wallpaper).setOnClickListener {
            backgroundImage(array.random())
        }
    }

    private fun backgroundImage(image: Int){
        findViewById<ConstraintLayout>(R.id.constraintLayout_Setting).background = AppCompatResources.getDrawable(this, image)
    }
}