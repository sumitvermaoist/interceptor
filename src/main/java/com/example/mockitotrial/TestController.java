package com.example.mockitotrial;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "some-test",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTest(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
