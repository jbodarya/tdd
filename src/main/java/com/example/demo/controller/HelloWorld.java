package com.example.demo.controller;

import com.example.demo.pojo.Data;
import com.example.demo.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @Autowired
    private  HelloWorldService helloWorldService;

    @GetMapping("/{value}")
    public String getVal(@PathVariable("value") String value){

        Integer.parseInt(value);
        return "hello " + helloWorldService.getValue(value);
    }

    @PostMapping("/{value}")
    public String postVal(@PathVariable("value") String value){
        return HttpStatus.OK.toString();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Internal Server", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
