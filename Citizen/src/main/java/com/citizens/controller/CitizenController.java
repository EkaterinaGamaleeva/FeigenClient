package com.citizens.controller;

import com.citizens.Feigen.SalaryCitizen;
import com.citizens.Feigen.WeatherApiClient;
import com.citizens.model.BodyRequest;
import com.citizens.service.CitizenService;
import com.citizens.model.Citizen;
import com.netflix.discovery.EurekaClient;
import jakarta.validation.Valid;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final WeatherApiClient weatherApiClient;
    private final SalaryCitizen salaryCitizen;
    private final CitizenService citizenService;
    private final BodyRequest bodyRequest;

    @Autowired
    public CitizenController(WeatherApiClient weatherApiClient, SalaryCitizen salaryCitizen, CitizenService citizenService, BodyRequest bodyRequest) {
        this.weatherApiClient = weatherApiClient;
        this.salaryCitizen = salaryCitizen;
        this.citizenService = citizenService;
        this.bodyRequest = bodyRequest;
    }

    @GetMapping
    public ResponseEntity getCitizens() {
        return new ResponseEntity(citizenService.getCitizen(), HttpStatus.OK);

    }

    @GetMapping(value = "/data/{city}")
    public ResponseEntity getTempByCity(@PathVariable(value = "city") String city) {
        Map<String, Object> map = new HashMap<>();
        // название и температура города
        String newCity = weatherApiClient.getWeather(city).toString();
        //все жители города
        List<Citizen> citizenList = citizenService.getCitizenCity(city);
        List<Citizen> newCitizenList = citizenList.stream().peek(e -> e.setCity(newCity)).collect(Collectors.toList());
        map.put("Все жители города", newCitizenList);

        //добавление средней зарплаты
        bodyRequest.setIntegers(newCitizenList.stream().map(e -> e.getSalary()).collect(Collectors.toList()));
        map.put("Средняя зарплата", salaryCitizen.getSalaryCitizen(bodyRequest));
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity getCitizensCity(@PathVariable(value = "city") String city) {
        return new ResponseEntity(citizenService.getCitizenCity(city), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Citizen citizen) {
        citizenService.save(citizen);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
