package com.citizens.Feigen;//package com.citizens.Feigen;

import com.citizens.model.CityResponse;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weather-service")
public interface WeatherApiClient {
    @GetMapping("/{city}")
    public CityResponse getWeather(@PathVariable("city") String city);
}
