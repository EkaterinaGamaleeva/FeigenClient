package com.citizens.Feigen;

import com.citizens.model.BodyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "salary-service")
public interface SalaryCitizen {
    @RequestMapping(method = RequestMethod.POST)
    public Integer getSalaryCitizen(@RequestBody BodyRequest bodyRequest);
}
