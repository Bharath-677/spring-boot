package com.tejait.batch15.exceptions;

public class InsuffiecentFundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsuffiecentFundsException() {
		super();
	}

	
	public InsuffiecentFundsException(String msg) {
		super(msg);
	}
	
}
