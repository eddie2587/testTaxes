package ro.reply.taxes.exceptions;


public class GenericCodedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1567567457645L;
	private String code;

	public GenericCodedException(String message, Throwable cause, String code) {
		super(message, cause);
	}
/**
 * An exception that provides a code as a string for later usage.
 * 
 * @param message logging message
 * @param code error code for internationalization
 */
	public GenericCodedException(String message, String code) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
