package com.example.expressionlanguagetest.business;

import com.example.expressionlanguagetest.dto.TestDto;

import java.util.List;

public interface TestService {

    boolean testRelationalOperator(TestDto testDto);
    boolean testRelationalOperatorButList(TestDto testDto);
}
