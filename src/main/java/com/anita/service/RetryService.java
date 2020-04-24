package com.anita.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;

import org.springframework.stereotype.Service;

import com.anita.exception.RemoteServiceNotAvailableException;

@Service
public class RetryService {

	  int counter =0;
	  private static final Logger LOGGER=LoggerFactory.getLogger(RetryService.class);
	  
	  
	  @Retryable(value = { RemoteServiceNotAvailableException.class }, maxAttempts = 2, backoff = @Backoff(delay = 5000))
	    public String simpleRetry() throws RemoteServiceNotAvailableException {
	        counter++;
	        LOGGER.info("Service Failed "+ counter);
	       
	        throw new RemoteServiceNotAvailableException("failed");
	    }
	  
	  
	  
	    @Recover
	    public String recover(RemoteServiceNotAvailableException t){
	    	LOGGER.info("Service recovering");
	        return "Service recovered from billing service failure.";
	    }
}
