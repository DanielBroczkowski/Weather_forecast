package com.example.weatherforecast.ApiConnection.WeatherClasses

class WeatherMain(var temp: String, var pressure: String, var tempc: Float) {

    fun colorChange(): String{
        tempc = temp.toFloat() - 273.15f
        val color: String
        if (tempc < -30){
            color = "#4c47e6"
        }
        else if (tempc < -20){
            color = "#4779e6"
        }
        else if (tempc < -10){
            color = "#47a6e6"
        }
        else if (tempc < 0){
            color = "#47d0e6"
        }
        else if (tempc < 11){
            color = "#a8f7dc"
        }
        else if (tempc < 21){
            color = "#e65247"
        }
        else if (tempc < 30){
            color = "#e64747"
        }
        else{
            color = "#bf3f3f"
        }


        return color
    }
}