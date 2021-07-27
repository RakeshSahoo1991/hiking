/**
 * 
 */
package com.element.hiking.exception;

/**
 * @author srake
 *
 */
public class BookingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1644712503218220207L;

	private String errorMsg;

	public BookingException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
