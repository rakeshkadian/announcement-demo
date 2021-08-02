package com.pil.announcement.core.response;

/**
 * @author Rakesh kadian
 *
 */
public enum ResponseStatus {
	
	FAILED("FAILED"),SUCCESS("SUCCESS");
	
	
	private String status;
	
	private ResponseStatus(String status){
		this.status=status;
	}

	public String getStatus() {
		return status;
	}
	
	

}
