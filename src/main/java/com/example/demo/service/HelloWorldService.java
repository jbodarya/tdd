package com.example.demo.service;

import com.example.demo.repo.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Autowired
    Crud crud;
    public String getValue(String value)
    {
        return Crud.getData().getValue();
    }
}
