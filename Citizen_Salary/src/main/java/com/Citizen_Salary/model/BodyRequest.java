package com.Citizen_Salary.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Data
public class BodyRequest {
    private List<Integer> integers;
}
