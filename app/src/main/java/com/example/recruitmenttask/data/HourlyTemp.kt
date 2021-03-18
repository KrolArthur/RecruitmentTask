package com.example.recruitmenttask.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HourlyTemp(
    @SerializedName("temp") val temp: Float,
    @SerializedName("hour") val hour: Int
): Serializable{

}
