package com.example.exapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exapi.data.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchByCity("Logroño")
    }

    private fun initRecyclerView(){
        adapter = WeatherAdapter()
        binding.temperatura.layoutManager = LinearLayoutManager(this)
    }
    // https://api.openweathermap.org/data/2.5/weather?q=London&appid=8ac149135d46fa405913aee0781f1498&units=metric&lang=es

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByCity(ciudad:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getWeatherByCity("weather?q=$ciudad&appid=8ac149135d46fa405913aee0781f1498&units=metric&lang=es")
            val temperatura = call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    var temp = temperatura?.temperatura
                    val tv: TextView = findViewById(R.id.temperatura)
                    tv.text = temp.toString()
                }else{
                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

}