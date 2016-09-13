package com.konradvincent2software.proxibanquesi.exception;

public class CompteServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2140652444662783112L;

	public CompteServiceException(){
		super();
	}
	
	public CompteServiceException(String details){
		super(details);
	}

}
