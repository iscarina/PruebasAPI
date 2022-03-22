package com.example.exapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(var temperatura:Double): RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layIn : LayoutInflater = LayoutInflater.from(parent.context)
        return WeatherViewHolder(layIn.inflate(R.layout.activity_main,parent,false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        var item:Double = temperatura
        holder.bind(item)
    }

    override fun getItemCount(): Int = 1
}