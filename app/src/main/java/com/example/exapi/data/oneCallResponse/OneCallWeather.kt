package com.example.exapi.data.oneCallResponse

import com.google.gson.annotations.SerializedName

data class OneCallWeather(
    @SerializedName("current")
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)