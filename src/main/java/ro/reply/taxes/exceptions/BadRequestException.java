package ro.reply.taxes.exceptions;

/**
 * A request that is not correctly constructed. Information is missing or
 * standards are not matched.
 */
public class BadRequestException extends GenericCodedException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6048122075096815526L;

	/**
	 * BadRequestException constructor.
	 * 
	 * @param message
	 *            - logging message
	 * @param cause
	 *            - inherited from Error
	 * @param code
	 *            - the code by which an internationalized message is shown to
	 *            the user to describe the exception.
	 */
	public BadRequestException(String message, Throwable cause, String code) {
		super(message, cause, code);
	}

	/**
	 * BadRequestException constructor.
	 * 
	 * @param message
	 *            - logging message
	 * @param code
	 *            - the code by which an internationalized message is shown to
	 *            the user to describe the exception.
	 */
	public BadRequestException(String message, String code) {
		super(message, code);
	}
}
