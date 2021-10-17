package com.weather.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse
{

    @SerializedName("main")
    @Expose
    private MainResponse mainResponse;

    @SerializedName("sys")
    @Expose
    private SystemResponse systemResponse;

    @SerializedName("name")
    @Expose
    private String name;

    public WeatherResponse()
    {
    }


    public MainResponse getMainResponse() {
        return mainResponse;
    }

    public SystemResponse getSystemResponse() {
        return systemResponse;
    }

    public String getName() {
        return name;
    }
}
