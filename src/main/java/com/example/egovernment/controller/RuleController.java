package com.example.egovernment.controller;

import com.example.egovernment.model.UserView;
import com.example.egovernment.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RuleController {
    private final RuleService ruleService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public boolean getSolution(@RequestBody UserView userView) {
        return ruleService.findPath(userView);
    }
}
