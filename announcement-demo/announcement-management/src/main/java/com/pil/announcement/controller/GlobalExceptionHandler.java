/**
 * 
 */
package com.pil.announcement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pil.announcement.core.response.Response;
import com.pil.announcement.core.response.ResponseStatus;
import com.pil.announcement.exception.DuplicateAnnouncementException;

/**
 * @author Rakesh kadian
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * A function to handle Duplicate Announcement Exception and send
	 * appropriate response to the caller/client
	 * 
	 * @param ex
	 * @return an instance of {@link ResponseEntity} with an appropriate status
	 *         code
	 */
	@ExceptionHandler(value = DuplicateAnnouncementException.class)
	public ResponseEntity<Response> handleDuplicateAnnouncementException(DuplicateAnnouncementException exception) {

		LOGGER.error("An error occured", exception);

		StringBuilder message = new StringBuilder();
		message.append(exception.getMessage());

		Response applicationResponse = Response.status(ResponseStatus.FAILED, HttpStatus.CONFLICT.value(),
				message.toString(), null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(applicationResponse);

	}
}
