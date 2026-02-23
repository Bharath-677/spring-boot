package com.tejait.batch15.exceptions;

public class MailAlredyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MailAlredyExists() {
		super();
	}
	
	
	public MailAlredyExists(String msg) {
		super(msg);
	}
	
	
	
}
