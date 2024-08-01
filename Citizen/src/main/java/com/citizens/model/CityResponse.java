package com.citizens.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
public class CityResponse {
    public String city;
    public Integer temperature;

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
