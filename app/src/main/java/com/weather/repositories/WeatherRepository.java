package com.weather.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.weather.network.WeatherClient;
import com.weather.network.WeatherService;
import com.weather.responses.WeatherResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository
{

    private WeatherService weatherService;
    private HashMap<String, String> hashMap;

    public WeatherRepository()
    {
        weatherService = WeatherClient.getRetrofit().create(WeatherService.class);
        hashMap = new HashMap<>();
    }

    public LiveData<WeatherResponse> getWeatherByCityName(String cityName)
    {
        MutableLiveData<WeatherResponse> weatherResponseMutableLiveData = new MutableLiveData<>();

        hashMap.put("q", cityName);
        hashMap.put("appid", "c51dc626b3ff2300a98c48c43de40875");

        weatherService
                .getWeatherByCityName(hashMap)
                .enqueue(new Callback<WeatherResponse>()
                {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response)
                    {
                        weatherResponseMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t)
                    {
                        weatherResponseMutableLiveData.setValue(null);
                    }
                });

        return weatherResponseMutableLiveData;
    }
}
