package com.example.exapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getWeatherByCity(@Url url:String): Response<WeatherResponse>
}