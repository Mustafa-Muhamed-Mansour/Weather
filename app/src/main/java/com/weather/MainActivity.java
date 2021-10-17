package com.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.weather.databinding.ActivityMainBinding;
import com.weather.responses.MainResponse;
import com.weather.responses.SystemResponse;
import com.weather.responses.WeatherResponse;
import com.weather.viewmodel.WeatherViewModel;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding binding;
    private WeatherViewModel weatherViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initlization();
        clickedImageButton();

    }

    private void initlization()
    {
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }

    private void clickedImageButton()
    {

        binding.imgGetWeather.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String cityName = binding.searchCity.getText().toString();

                if (TextUtils.isEmpty(cityName))
                {
                    Toast.makeText(getApplicationContext(), "Please enter city name", Toast.LENGTH_SHORT).show();
                    binding.searchCity.requestFocus();
                    return;
                }
                else
                {
                    weatherViewModel.getWeatherByCityName(cityName).observe(MainActivity.this, new Observer<WeatherResponse>()
                    {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onChanged(WeatherResponse weatherResponse)
                        {
                            if (weatherResponse != null)
                            {
                                SystemResponse systemResponse = weatherResponse.getSystemResponse();
                                binding.txtCity.setText(weatherResponse.getName() + ", " + systemResponse.getCountry());
                                MainResponse mainResponse = weatherResponse.getMainResponse();
                                int tempCelsius = (int) (mainResponse.getTemperature() - 273.15);
                                binding.txtTemperature.setText(tempCelsius + " °C");
                            }
                        }
                    });

//                    binding.searchCity.getText().clear();
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        weatherViewModel.getWeatherByCityName("").removeObservers(MainActivity.this);
    }
}