package com.example.weatherforecast.ApiConnection.WeatherClasses

class WeatherDetail(var description: String, var id: Int) {

    fun iconPicker() : Int{
        var ico : Int
        if ((id > 199) && (id < 233)){
             ico = 0 //storm
        }
        else if ((id > 299) && (id < 322)){
            ico = 1 //rain
        }
        else if ((id > 499) && (id < 505)){
            ico = 2 //sunrain
        }
        else if ((id > 510) && (id < 532)){
            ico = 3 //moonrain
        }
        else if ((id > 599) && (id < 623)){
            ico = 4 //snow
        }
        else if ((id > 700) && (id < 782)){
            ico = 5 //mist
        }
        else if (id == 800){
            ico = 6 //clear
        }
        else{
            ico = 7 //clouds
        }

        return ico
    }
}