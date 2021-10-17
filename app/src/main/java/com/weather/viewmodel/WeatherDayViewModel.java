package com.weather.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.weather.network.WeatherClient;
import com.weather.network.WeatherService;
import com.weather.repositories.WeatherRepository;
import com.weather.responses.WeatherResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel
{

    public WeatherRepository weatherRepository;

    public WeatherViewModel()
    {
        weatherRepository = new WeatherRepository();
    }

    public LiveData<WeatherResponse> getWeatherByCityName(String cityName)
    {
        return weatherRepository.getWeatherByCityName(cityName);
    }
}
