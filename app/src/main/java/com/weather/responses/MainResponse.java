package com.weather.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public class MainResponse
{

    @SerializedName("temp")
    @Expose
    private Double temperature;

    public MainResponse()
    {
    }

    public Double getTemperature() {
        return temperature;
    }
}
