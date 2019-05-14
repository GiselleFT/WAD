package escom.ttb020.controlacceso.bs.exception;

public class RepeatedUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656933286890413011L;
	
	public RepeatedUserException() {
		super();
	}

	public RepeatedUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RepeatedUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatedUserException(String message) {
		super(message);
	}

	public RepeatedUserException(Throwable cause) {
		super(cause);
	}

}
