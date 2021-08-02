/**
 * 
 */
package com.pil.announcement.service;

import java.util.List;

import com.pil.announcement.core.response.DataEnvelope;
import com.pil.announcement.request.AnnouncementRequest;

/**
 * @author Rakesh kadian
 *
 */
public interface AnnouncementService {
	
	/**
	 * This function is used to create 
	 * announcements in to database
	 * 
	 * @param announcementRequest
	 */
	public void createAnnouncement(final AnnouncementRequest announcementRequest);
	
	/**
	 * This function is used to retrieve all the 
	 * Announcements
	 * 
	 * @return
	 */
	public List<DataEnvelope>  retrieveAllAnnouncements();

}
