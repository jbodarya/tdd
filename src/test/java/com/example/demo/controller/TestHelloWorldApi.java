package com.example.demo.controller;

import com.example.demo.pojo.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestHelloWorldApi {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getTesting() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/66").toString(), String.class);
        assertEquals("hello 21", response.getBody());

    }

    @Test
    public void postTesting() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        Data data = new Data();
        data.setValue("555");
        HttpEntity<Data> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> response = this.restTemplate.postForEntity(new URI("http://localhost:" + port + "/66"),
                request, String.class);

        assertEquals(200, response.getStatusCode().value());

    }
}