package com.example.demo.controller;

import com.example.demo.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestHelloWorld {

   @InjectMocks
    HelloWorld testHelloWorld;

    @Mock
    HelloWorldService helloWorldService;

    @Test
    public void testHelloWorld(){

        when(helloWorldService.getValue(any())).thenReturn("333");
        assertEquals(testHelloWorld.getVal("333"),"hello 333");
    }

}
