package com.anita.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.anita.dao.AuditDao;
import com.anita.interceptor.CustomRequestInterceptor;

@Configuration
public class RequestAppConfig implements WebMvcConfigurer {
	
	
	 @Autowired
	 private CustomRequestInterceptor customRequestInterceptor;

	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(customRequestInterceptor)
	   .addPathPatterns("/retryservice3");
	 
	 }
}
