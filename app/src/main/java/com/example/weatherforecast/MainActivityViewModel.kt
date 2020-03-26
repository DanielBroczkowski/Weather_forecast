package com.example.weatherforecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.ApiConnection.SearchClasses.Search
import com.example.weatherforecast.ApiConnection.WeatherClasses.Weather

class MainActivityViewModel: ViewModel() {
    val search = Search()
    fun getWeather(city : String){
        search.searching(city)
    }

    fun getLiveData(): LiveData<Weather>{
        return search.weatherData
    }
}