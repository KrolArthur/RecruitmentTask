package com.example.recruitmenttask.ui.task4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recruitmenttask.R
import com.example.recruitmenttask.data.WeatherData
import org.w3c.dom.Text
import java.lang.StringBuilder

class Task4Adapter(private val data: List<WeatherData>): RecyclerView.Adapter<Task4Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weatherImg: ImageView
        val cityName: TextView
        val HourData: TextView
        val TempData: TextView

        init {
            weatherImg = view.findViewById(R.id.weatherImgView)
            cityName = view.findViewById(R.id.cityNameTextView)
            HourData = view.findViewById(R.id.HourDataTextView)
            TempData = view.findViewById(R.id.TempDataTextView)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.data_row, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        when(data[position].weather){
            "sunny" -> viewHolder.weatherImg.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
            "cloudy" -> viewHolder.weatherImg.setImageResource(R.drawable.ic_baseline_wb_cloudy_24)
            "rainy" -> viewHolder.weatherImg.setImageResource(R.drawable.ic_rain)
        }
        viewHolder.cityName.text = data[position].city
        val strHours = StringBuilder()
        val strTemps = StringBuilder()
        strHours.append("H\n")
        strTemps.append("°C\n")
        data[position].hourly_temp.forEach {
            strHours.append("${it.hour}\n")
            strTemps.append("${it.temp}\n")
        }
        viewHolder.HourData.text = strHours
        viewHolder.TempData.text = strTemps
    }
    override fun getItemCount() = data.size
}