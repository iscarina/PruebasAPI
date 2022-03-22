package com.example.exapi
import com.google.gson.annotations.SerializedName

data class WeatherResponse (@SerializedName("coord.lon") var lon:Double,
                            @SerializedName("coord.lat") var lat:Double,
                            @SerializedName("weather.id") var IdWeather:Int,
                            @SerializedName("weather.main") var descripcionCorta:String,
                            @SerializedName("weather.description") var descripcion:String,
                            @SerializedName("weather.icon") var icono:String,
                            @SerializedName("base") var base:String,
                            @SerializedName("main.temp") var temperatura:Double,
                            @SerializedName("main.feels_like") var sensacionTermica:Double,
                            @SerializedName("main.temp_min") var temperaturaMinima:Double,
                            @SerializedName("main.temp_max") var temperaturaMaxima:Double,
                            @SerializedName("main.pressure") var presion:Double,
                            @SerializedName("main.humidity") var humedad:Double,
                            @SerializedName("visibility") var visibilidad:Double,
                            @SerializedName("wind.speed") var velocidadViento:Double,
                            @SerializedName("wind.deg") var direccionViento:Double,
                            @SerializedName("dt") var dataTime:Double,
                            @SerializedName("sys.type") var tipo:Double,
                            @SerializedName("sys.id") var idInterno:Int,
                            @SerializedName("sys.country") var pais:String,
                            @SerializedName("sys.sunsrise") var amanecer:Double,
                            @SerializedName("sys.sunset") var puestaDeSol:Double,
                            @SerializedName("timezone") var SecondsFromUTC:Double,
                            @SerializedName("id") var idCiudad:Int,
                            @SerializedName("name") var nombreCiudad:String,
                            @SerializedName("cod") var codInterno:String,
                            ){
}