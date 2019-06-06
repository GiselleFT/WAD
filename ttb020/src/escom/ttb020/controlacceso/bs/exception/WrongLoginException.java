package escom.ttb020.controlacceso.bs.exception;

public class WrongLoginException extends Exception {

	/**Excepci�n para login incorrecto
	 * 
	 */
	private static final long serialVersionUID = 6954293740291573583L;

	public WrongLoginException() {
		super();

	}

	public WrongLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public WrongLoginException(String message, Throwable cause) {
		super(message, cause);

	}

	public WrongLoginException(String message) {
		super(message);

	}

	public WrongLoginException(Throwable cause) {
		super(cause);

	}

}
