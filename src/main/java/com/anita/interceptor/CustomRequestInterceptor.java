package com.anita.interceptor;

import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.anita.dao.AuditDao;
import com.anita.dto.AuditDto;
import com.anita.entity.AuditEntity;


@Component
public class CustomRequestInterceptor extends HandlerInterceptorAdapter{
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomRequestInterceptor.class);
	
	@Autowired
	private AuditDao auditDao;

	
	@Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

	  long startTime = Instant.now().toEpochMilli();
	  LOGGER.info("Request URL::" + request.getRequestURL().toString() +
	   ":: Start Time=" + Instant.now());
	  request.setAttribute("startTime", startTime);
	  return true;
	 }

	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

	  long startTime = (Long) request.getAttribute("startTime");

	  LOGGER.info("Request URL::" + request.getRequestURL().toString() +
	   ":: Time Taken=" + (Instant.now().toEpochMilli() - startTime));
	  Date date = new Date();
	  AuditEntity auditdto = new AuditEntity();
	  auditdto.setUrl(request.getRequestURL().toString() );
	  auditdto.setDate(date);
	 auditDao.save(auditdto);
	  
	 }

}
