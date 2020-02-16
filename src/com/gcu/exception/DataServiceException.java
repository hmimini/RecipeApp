package com.gcu.exception;

/**
 * Custom exception used in the controller and thrown in the Data Services.
 * 
 * @author Hermes Mimini
 *
 */
public class DataServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Method that is thrown in Data Services
	 * 
	 * @param e - SQLException caught in the data service.
	 */
	public DataServiceException(Throwable e) {
		super(e);
	}

}
