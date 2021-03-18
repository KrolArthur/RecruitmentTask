package com.example.recruitmenttask.ui

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recruitmenttask.R
import com.example.recruitmenttask.data.WeatherData
import com.example.recruitmenttask.data.WeatherDataAnalyzer
import com.example.recruitmenttask.ui.task4.Task4Activity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t1 = findViewById<Button>(R.id.task1Btn)
        val t2 = findViewById<Button>(R.id.task2Btn)
        val t3 = findViewById<Button>(R.id.task3Btn)
        val t4 = findViewById<Button>(R.id.task4Btn)



        val json = """
    [
       {
          "city":"Warsaw",
          "weather":"rainy",
          "hourly_temp":[
             { "temp":-2, "hour":0 },
             { "temp":-2, "hour":4 },
             { "temp":0.5, "hour":8 },
             { "temp":2, "hour":12 },
             { "temp":3, "hour":16 },
             { "temp":-1, "hour":20 }
          ]
       },
       {
          "city":"Paris",
          "weather":"cloudy",
          "hourly_temp":[
             { "temp":11, "hour":0 },
             { "temp":14, "hour":4 },
             { "temp":18, "hour":8 },
             { "temp":22, "hour":12 },
             { "temp":15, "hour":16 },
             { "temp":13, "hour":20 }
          ]
       },
       {
          "city":"Berlin",
          "weather":"sunny",
          "hourly_temp":[
             { "temp":-6, "hour":0 },
             { "temp":-4, "hour":4 },
             { "temp":2, "hour":8 },
             { "temp":4, "hour":12 },
             { "temp":5.5, "hour":16 },
             { "temp":3, "hour":20 }
          ]
       },
       {
          "city":"New York",
          "weather":"cloudy",
          "hourly_temp":[
             { "temp":12, "hour":0 },
             { "temp":13, "hour":4 },
             { "temp":12, "hour":8 },
             { "temp":15, "hour":12 },
             { "temp":16, "hour":16 },
             { "temp":14, "hour":20 }
          ]
       }
    ]
""".trimIndent()

        val gson = Gson()

        val founderListType: Type = object : TypeToken<ArrayList<WeatherData?>?>() {}.type

        val data: List<WeatherData> = gson.fromJson(json, founderListType)
        val analyzer = WeatherDataAnalyzer(data)
        Log.d("ELO", analyzer.getLowestAvgTempCity().toString())
        setOnClickListeners(t1, t2, t3, t4, analyzer)

    }

    private fun setOnClickListeners(t1: Button, t2: Button, t3: Button, t4: Button, analyzer: WeatherDataAnalyzer) {
        val builder = AlertDialog.Builder(this)
        t1.setOnClickListener {
            builder.setMessage(analyzer.getLowestTemp().toString())
                    .setCancelable(true)
            val alert = builder.create()
            alert.setTitle("Task1")
            alert.show()
        }
        t2.setOnClickListener {
            builder.setMessage(analyzer.getHighestTempForCities())
                    .setCancelable(true)
            val alert = builder.create()
            alert.setTitle("Task2")
            alert.show()
        }
        t3.setOnClickListener {
            builder.setMessage(analyzer.getLowestAvgTempCity())
                    .setCancelable(true)
            val alert = builder.create()
            alert.setTitle("Task3")
            alert.show()
        }
        t4.setOnClickListener {
            val intent = Intent(this, Task4Activity::class.java).apply {
                putExtra("data", analyzer)
            }
            startActivity(intent)
        }
    }
}