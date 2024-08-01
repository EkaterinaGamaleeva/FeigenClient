package com.citizens.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class BodyRequest {
    private List<Integer> integers;
}
