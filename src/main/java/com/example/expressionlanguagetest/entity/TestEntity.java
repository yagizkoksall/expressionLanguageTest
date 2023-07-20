package com.example.expressionlanguagetest.entity;

import com.example.expressionlanguagetest.dto.TestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    private String name;
    private String lastName;

    public boolean isMember(String testName){
       List<String> list = new ArrayList<>();
       list.add("Nikola");
       list.add("Deneme");

        return list.stream().anyMatch(item -> item.equals(testName));
    }

    public boolean isMemberButList(List<String> list2){
        List<String> list = new ArrayList<>();
        list.add("Nikola");
        list.add("Deneme");



        return list.stream().anyMatch(item -> list2.stream().anyMatch(item::equals));
    }
}
