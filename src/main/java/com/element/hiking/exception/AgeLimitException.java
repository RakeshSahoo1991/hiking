/**
 * 
 */
package com.element.hiking.exception;

/**
 * @author srake
 *
 */
public class AgeLimitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5590203875092542092L;

	private String errorMsg;

	public AgeLimitException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
