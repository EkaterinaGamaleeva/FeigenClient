package com.Citizen_Salary.service;

import com.Citizen_Salary.model.BodyRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Service

public class AverageSalaryService {

    public Integer getAverageSalary(BodyRequest bodyRequest){
        List<Integer> integers= bodyRequest.getIntegers();
        if (integers==null){
            return 0;
        }
        return integers.stream().reduce(0,(a,e)->a+e/integers.size()).intValue();
    }
    }

