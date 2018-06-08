package com.smart.sso.client;

import java.io.Serializable;

public class OtherSession implements Serializable{

	private static final long serialVersionUID = 4990567864001655704L;
	
	private Object sessionValue;
	
	public OtherSession() {
		super();
	}
			
	public OtherSession(Object sessionValue) {
		super();
		this.sessionValue = sessionValue;
	}

	public Object getSessionValue() {
		return sessionValue;
	}

	public void setSessionValue(Object sessionValue) {
		this.sessionValue = sessionValue;
	}
	
	
}
