package com.example.exapi.data

import com.example.exapi.data.currentResponse.CurrentWeatherResponse
import com.example.exapi.data.oneCallResponse.OneCallWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "8ac149135d46fa405913aee0781f1498"

interface APIService {
    // https://api.openweathermap.org/data/2.5/weather?q=London&appid=8ac149135d46fa405913aee0781f1498&units=metric&lang=es
    @GET("weather")
    fun getCurrentWeatherByCity(
        @Query("q") ciudad: String,
        @Query("lang") codigoLenguaje: String = "es",
        @Query("units") unidadesTemp: String = "metric"
    ): Deferred<CurrentWeatherResponse>

    @GET("weather")
    fun getCurrentWeatherByCoords(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("lang") codigoLenguaje: String = "es",
        @Query("units") unidadesTemp: String = "metric"
    ): Deferred<CurrentWeatherResponse>

    // https://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely&appid=8ac149135d46fa405913aee0781f1498

    @GET("onecall")
    fun getWeatherOneCall(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("lang") codigoLenguaje: String = "es",
        @Query("units") unidadesTemp: String = "metric"
    ): Deferred<OneCallWeather>

    companion object{
        operator fun invoke():APIService{
            val requestInterceptor = Interceptor{ chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
        }
    }
}