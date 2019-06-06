package escom.ttb020.controlacceso.bs.exception;

public class UserNotFoundException extends Exception {

	/**Excepci�n para usuario no encontrado
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
}
