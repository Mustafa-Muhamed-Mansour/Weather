package com.weather.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weather.databinding.ItemWeatherBinding;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>
{


    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new WeatherViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position)
    {
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder
    {
        private ItemWeatherBinding binding;

        public WeatherViewHolder(@NonNull ItemWeatherBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
