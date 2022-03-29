package com.example.exapi.data.response

import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    val cod: Int,
    @SerializedName("coord")
    val coord: Coord,
    val dt: Int,
    val id: Int,
    @SerializedName("main")
    val main: Main,
    val name: String,
    @SerializedName("sys")
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
)