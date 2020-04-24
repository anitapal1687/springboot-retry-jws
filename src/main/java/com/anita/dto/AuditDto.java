package com.anita.dto;

import java.io.Serializable;
import java.util.Date;


public class AuditDto{


private String url;
private Date date;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
