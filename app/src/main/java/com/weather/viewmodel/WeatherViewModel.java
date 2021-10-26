package com.weather.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.weather.repositories.WeatherDayRepository;
import com.weather.responses.WeatherResponse;

public class WeatherDayViewModel extends ViewModel
{

    public WeatherDayRepository weatherDayRepository;

    public WeatherDayViewModel()
    {
        weatherDayRepository = new WeatherDayRepository();
    }

    public LiveData<WeatherResponse> getWeatherByCityName(String cityName)
    {
        return weatherDayRepository.getWeatherByCityName(cityName);
    }
}
