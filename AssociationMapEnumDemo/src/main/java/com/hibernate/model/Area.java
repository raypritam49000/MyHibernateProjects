package com.hibernate.model;

public enum Area {
	SMALL(0), MEDIUM(1), LARGE(2);
	 
	private int code;
 
	private Area(int code) {
		this.code = code;
	}
 	public int getStatusCode() {
		return code;
	}
}
 

