package com.example.exapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.exapi.data.APIService
import com.example.exapi.data.oneCallResponse.OneCallWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = APIService()
        GlobalScope.launch(Dispatchers.Main){
            val OneCallWeather = apiService.getWeatherOneCall(12.0,12.0).await()
            val tv : TextView = findViewById(R.id.textView)
            tv.text = OneCallWeather.hourly.get(2).temp.toString()
        }
    }
}