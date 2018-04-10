package org.latko.random.service;

public class RandomServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public RandomServiceException() {
        super();
    }

    public RandomServiceException(final String message) {
        super(message);
    }

    public RandomServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RandomServiceException(final Throwable cause) {
        super(cause);
    }

}
