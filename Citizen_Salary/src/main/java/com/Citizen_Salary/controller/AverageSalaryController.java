package com.Citizen_Salary.controller;
import com.Citizen_Salary.model.BodyRequest;
import com.Citizen_Salary.service.AverageSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class AverageSalaryController {
    private final AverageSalaryService averageSalaryService;
@Autowired
    public AverageSalaryController(AverageSalaryService averageSalaryService) {
        this.averageSalaryService = averageSalaryService;
    }


    @PostMapping()
    public ResponseEntity getSalary(@RequestBody BodyRequest bodyRequest){
        return new ResponseEntity(averageSalaryService.getAverageSalary(bodyRequest), HttpStatus.OK);

    }
}
