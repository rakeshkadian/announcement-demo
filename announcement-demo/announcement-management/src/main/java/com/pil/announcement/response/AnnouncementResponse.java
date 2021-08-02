/**
 * 
 */
package com.pil.announcement.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pil.announcement.core.response.DataEnvelope;

/**
 * @author Rakesh kadian
 *
 */
public class AnnouncementResponse implements Serializable,DataEnvelope {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8506122114059188938L;

	private String title;
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date announcementDate;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the announcementDate
	 */
	public Date getAnnouncementDate() {
		return announcementDate;
	}

	/**
	 * @param announcementDate
	 *            the announcementDate to set
	 */
	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	@Override
	public String toString() {
		return "AnnouncementResponse [title=" + title + ", description=" + description + ", announcementDate="
				+ announcementDate + "]";
	}

}
