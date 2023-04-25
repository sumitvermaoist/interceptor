package com.example.mockitotrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetryService {


    @Autowired
    private RetryDAO retryDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Retryable
    @Async
    public void retry(){
        System.out.println( "retry" + "called");
        retryDAO.someMethod();

        restTemplate.exchange("www.google.com", HttpMethod.GET,null,String.class);

    }

    @Recover
    public void recover(Exception exception) throws Exception {
        System.out.println("recover " + "called");

        if((exception instanceof  RuntimeException)){
            return;
        }

        if(exception instanceof NumberFormatException){
            throw new NumberFormatException();
        }
    }
}
