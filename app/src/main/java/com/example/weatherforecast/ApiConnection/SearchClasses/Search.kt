package com.example.weatherforecast.ApiConnection.SearchClasses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherforecast.ApiConnection.WeatherClasses.Weather
import com.example.weatherforecast.ApiConnection.WeatherInterface.IWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback


//Callback<Weather>,

class Search: Callback<Weather> {
    override fun onFailure(call: Call<Weather>, t: Throwable) {
        t.printStackTrace()
    }

    override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
        if (response.isSuccessful){
            weatherData.value = response.body()
        }
    }

    var weatherData: MutableLiveData<Weather> = MutableLiveData()
    fun searching(city: String){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/weather/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val IRest = retrofit.create(IWeather :: class.java)
        val whatever = IRest.searchFun(city)
        whatever.enqueue(this)
    }
}