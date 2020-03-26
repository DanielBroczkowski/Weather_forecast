package com.example.weatherforecast.ApiConnection.WeatherInterface

import com.example.weatherforecast.ApiConnection.WeatherClasses.Weather
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeather {
    @GET("?appid=73e04a151ff7847e4142f6c5407304fa")
    fun searchFun(@Query("q")zmienna: String):retrofit2.Call<Weather>
}