/**
 * 
 */
package com.pil.announcement.core.response;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Rakesh kadian
 *
 */
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289147100804430262L;

	private ResponseStatus status;
	private Integer code;
	private String message;
	private Collection<DataEnvelope> data;
	private String requestURI;

	private Response(ResponseStatus status, Integer code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public static Response status(ResponseStatus status, Integer code, String message, String requestUri) {
		Response response = new Response(status, code, message);
		response.requestURI = requestUri;
		return response;
	}
	
	public Response data(Collection<DataEnvelope> data) {
		this.data = data;
		return this;
	}
	
	public ResponseStatus getStatus() {
		return status;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getRequestURI() {
		return requestURI;
	}
	
	public Collection<DataEnvelope> getData() {
		return data;
	}

}
