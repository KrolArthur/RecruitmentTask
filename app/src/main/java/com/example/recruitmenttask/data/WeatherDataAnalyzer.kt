package com.example.recruitmenttask.data

import java.io.Serializable
import java.lang.Exception
import java.lang.StringBuilder

data class WeatherDataAnalyzer (
    val data: List<WeatherData>
        ): Serializable {
    /*
    Task 1
     */
    fun getLowestTemp(): Float{
        var lowestTemp: Float = data[0].hourly_temp[0].temp
        data.forEach {
            val minForCity: Float = it.hourly_temp.minOf { value -> value.temp }
            if(lowestTemp > minForCity)
                lowestTemp = minForCity
        }
        return lowestTemp
    }
    /*
    Task 2
     */
    fun getHighestTempForCities(): String{
        val result = StringBuilder()
        data.forEach {
            result.append(it.getHighestTemp() + "\n")
        }
        return result.toString()
    }
    /*
    Task 3
     */
    fun getAvgCitiesTemps(): MutableMap<String, Float>{
        val avgCitiesTemps: MutableMap<String, Float> = mutableMapOf()
        data.forEach {
            avgCitiesTemps[it.city] = it.getAvgTemp()
        }
        return avgCitiesTemps
    }
    fun getLowestAvgTempCity(): String {
        return getAvgCitiesTemps().toList().sortedBy { (_, v) -> v }.toMap().entries.first().key
    }
}