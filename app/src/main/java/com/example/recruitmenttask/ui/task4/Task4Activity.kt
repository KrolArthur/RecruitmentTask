package com.example.recruitmenttask.ui.task4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recruitmenttask.R
import com.example.recruitmenttask.data.WeatherData
import com.example.recruitmenttask.data.WeatherDataAnalyzer

class Task4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val backBtn = findViewById<Button>(R.id.backBtn)

        val dataAnalyzer = intent.getSerializableExtra("data") as WeatherDataAnalyzer
        recyclerView.adapter = Task4Adapter(dataAnalyzer.data)
        recyclerView.layoutManager = LinearLayoutManager(this);

        backBtn.setOnClickListener {
            this.finish()
        }
    }
}