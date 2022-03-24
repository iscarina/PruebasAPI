package com.example.exapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exapi.data.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {
    companion object{
        fun nueva() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)
            .get(CurrentWeatherViewModel::class.java)

        val apiService = APIService()

        GlobalScope.launch(Dispatchers.Main){
            val currentWeatherResponse = apiService.getCurrentWeather("Logroño").await()
            val tv =  (TextView) findViewById(R.id.textView)
            tv = currentWeatherResponse.main.toString()
        }
    }
}