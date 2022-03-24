package com.example.exapi.data

import com.example.exapi.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "8ac149135d46fa405913aee0781f1498"

// https://api.openweathermap.org/data/2.5/weather?q=London&appid=8ac149135d46fa405913aee0781f1498&units=metric&lang=es

interface APIService {
    @GET("weather")
    fun getCurrentWeather(
        @Query("q") ciudad: String,
        @Query("lang") codigoLenguaje: String = "es",
        @Query("units") unidadesTemp: String = "metric"
    ): Deferred<CurrentWeatherResponse>

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