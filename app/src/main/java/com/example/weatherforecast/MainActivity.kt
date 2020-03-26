package com.example.weatherforecast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.round
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainActivityViewModel =
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                MainActivityViewModel::class.java
            )



        searchImageButton.setOnClickListener {
            mainActivityViewModel.getWeather(cityEditText.text.toString())
        }

        mainActivityViewModel.getLiveData().observe(this, Observer { pressureTextView.text = it.main.pressure + " hPa"
            sunriseText.text = dateParser(it.sys.sunrise.toLong())
            sunsetText.text = dateParser(it.sys.sunset.toLong())
            colorChange(it.main.colorChange())
            iconPicker(it.weather[0].iconPicker(), dayOrNight(it.sys.sunset.toLong()))
            temperatureTextView.text = round(it.main.tempc).toString()+ 0x00B0.toChar() + "C"
            verbalWeatherTextView.text = it.weather[0].description
            cityNameTextView.text = cityEditText.text.toString()
            dateText.text = getDate()
            timeText.text = getTime()
        })
    }

    fun colorChange(color: String){
        toolbar.setBackgroundColor(Color.parseColor(color))
    }

    fun dateParser(time :Long) : String{
        val sdf = SimpleDateFormat("HH:mm")
        val date = Date(time * 1000 + 3600000)
        return sdf.format(date)
    }

    fun getDate() : String{
        val date = Calendar.getInstance().time
        var formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(date)
    }

    fun getTime() : String{
        val date = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH:mm")
        return formatter.format(date)
    }

    fun dayOrNight(time : Long) : Int{
        val date = Calendar.getInstance().time
        var formatter = SimpleDateFormat("HH")
        var d1 = formatter.format(date)

        val sdf = SimpleDateFormat("HH")
        val date2 = Date(time * 1000)
        var d2 = sdf.format(date2)

        return if (d1 > d2){
            0
        } else 1
    }

    fun iconPicker(ico : Int, day : Int){
        if(ico == 0){
            weatherIcon.setImageResource(R.drawable.storm)
        }
        else if (ico == 1){
            weatherIcon.setImageResource(R.drawable.rain)
        }
        else if (ico == 2){
            weatherIcon.setImageResource(R.drawable.sunrain)
        }
        else if (ico == 3){
            weatherIcon.setImageResource(R.drawable.moonrain)
        }
        else if (ico == 4){
            weatherIcon.setImageResource(R.drawable.snow)
        }
        else if (ico == 5){
            weatherIcon.setImageResource(R.drawable.mist)
        }
        else if (ico == 6){
            if (day == 1){
                weatherIcon.setImageResource(R.drawable.sun)
            }
            else weatherIcon.setImageResource(R.drawable.moon)
        }
        else if (ico == 7){
            weatherIcon.setImageResource(R.drawable.clouds)
        }
    }

}
