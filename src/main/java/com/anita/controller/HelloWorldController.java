package com.anita.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anita.exception.RemoteServiceNotAvailableException;
import com.anita.service.RetryService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private RetryService retryService;
	
	@RequestMapping( value="/hello1", method = RequestMethod.GET )
	public String firstPage1() {
		return "Hello World";
	}

	
	@RequestMapping( value="/service1", method = RequestMethod.GET )
	public void firstPage2(String param, HttpServletResponse response) throws IOException {
		response.sendRedirect("/service2");
	}
	
	@RequestMapping( value="/service2", method = RequestMethod.GET )
	public String server2(String param, HttpServletResponse response) throws IOException {
		return "Hello World";
	}
	
	
	@RequestMapping( value="/retryservice3", method = RequestMethod.GET )
	    public String callRetryService() throws RemoteServiceNotAvailableException {
	       
			return retryService.simpleRetry();
	    }
	
}