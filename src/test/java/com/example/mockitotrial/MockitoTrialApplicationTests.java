package com.example.mockitotrial;

import com.fasterxml.jackson.core.JsonParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.UndeclaredThrowableException;

import static org.mockito.Mockito.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
class MockitoTrialApplicationTests {


	@Autowired // if everything worked right, you should get a proxy here actually (you can check that in debugger)
	private RetryService retryService;

	@MockBean
	private RetryDAO retryDAO;

	@MockBean
	private RestTemplate restTemplate;


	@Test
	void contextLoads() {
	}


	@Test
	public void testRetry(){

		when(retryDAO.someMethod()).thenThrow(RuntimeException.class);

		retryService.retry();
		verify(retryDAO,times(3)).someMethod();
	}

	@Test
	public void testRetryAgain(){

		when(retryDAO.someMethod()).thenThrow(NumberFormatException.class);

		Assertions.assertThrows(NumberFormatException.class,()->{retryService.retry();});


	}

}
