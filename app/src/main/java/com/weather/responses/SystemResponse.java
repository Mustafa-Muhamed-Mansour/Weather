package com.weather.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemResponse
{

    @SerializedName("country")
    @Expose
    private String country;


    public SystemResponse()
    {
    }

    public String getCountry() {
        return country;
    }
}
