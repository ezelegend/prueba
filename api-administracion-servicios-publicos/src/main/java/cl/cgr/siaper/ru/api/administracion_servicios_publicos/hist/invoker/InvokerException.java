package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker;

import java.io.Serializable;

public class InvokerException extends Exception implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -2540413121541820375L;

	/**
	 * Default constructor.
	 */
	public InvokerException() {
		super();
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param message
	 *            Message for this exception.
	 */
	public InvokerException(String message) {
		super(message);
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param message
	 *            Message for this exception.
	 * @param cause
	 *            Root cause of this exception.
	 */
	public InvokerException(String message, Throwable cause) {
		super(message, cause);
	}

}