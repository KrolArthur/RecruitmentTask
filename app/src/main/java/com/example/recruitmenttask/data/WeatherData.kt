package com.example.recruitmenttask.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherData(
    @SerializedName("city") val city: String,
    @SerializedName("weather") val weather: String,
    @SerializedName("hourly_temp") val hourly_temp: List<HourlyTemp>
): Serializable{
    fun getHighestTemp(): String {
        return "$city: ${hourly_temp.maxOf { it.temp }}"
    }
    fun getAvgTemp(): Float {
        var avgTemp: Float = 0f
        hourly_temp.forEach {
            avgTemp += it.temp
        }
        return avgTemp/hourly_temp.size
    }
}
