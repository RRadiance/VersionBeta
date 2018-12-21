package com.jimmoores.quandl.util;

/**
 * A runtime exception from the Quandl client indicating an HTTP 429 response code (Too many requests) and that subsequent retries according
 * to the session retry policy also failed. This generally may indicate that you've made more than your allowance of requests in that day. A
 * common solution is to use a proper API auth token (available via your account login on Quandl) to pass in when creating the
 * QuandlSession.
 */
public class QuandlRequestFailedException extends QuandlRuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor when another exception is being included.
   * 
   * @param message a message describing the exception, not null
   * @param cause the cause of the expection if there is one, not null
   */
  public QuandlRequestFailedException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor when exception is not caused by an underlying exception.
   * 
   * @param message a message describing the exception, not null
   */
  public QuandlRequestFailedException(final String message) {
    super(message);
  }
}
