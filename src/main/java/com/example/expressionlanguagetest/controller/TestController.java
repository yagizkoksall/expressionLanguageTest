package com.example.expressionlanguagetest.controller;

import com.example.expressionlanguagetest.business.TestService;
import com.example.expressionlanguagetest.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @PostMapping("/relationalOperator")
    public boolean relationalOperators(@RequestBody TestDto testDto){
        return testService.testRelationalOperator(testDto);
    }

    @PostMapping("/relationalOperatorButList")
    public boolean relationalOperatorsButList(@RequestBody TestDto testDto){
        return testService.testRelationalOperatorButList(testDto);
    }
}
