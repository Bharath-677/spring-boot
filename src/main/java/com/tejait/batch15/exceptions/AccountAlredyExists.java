package com.tejait.batch15.exceptions;

public class AccountAlredyExists extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAlredyExists() {
		super();
	}
	
	public AccountAlredyExists(String msg) {
		super(msg);
	}
	

}
