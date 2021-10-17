package com.weather.network;

import com.weather.responses.WeatherResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WeatherService
{
    @GET("weather")
    Call<WeatherResponse> getWeatherByCityName(@QueryMap HashMap<String, String> map);

}
