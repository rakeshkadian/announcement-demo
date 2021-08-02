/**
 * 
 */
package com.pil.announcement.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Rakesh kadian
 *
 */
public class AnnouncementRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6497863412575094483L;

	@NotBlank(message = "The field cannot be blank")
	private String title;
	@NotBlank(message = "The field cannot be blank")
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "The field cannot be blank")
	private Date announcementDate;

	public AnnouncementRequest() {

	}

	public AnnouncementRequest(String title, String description, Date announcementDate) {
		this.title = title;
		this.description = description;
		this.announcementDate = announcementDate;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the announcementDate
	 */
	public Date getAnnouncementDate() {
		return announcementDate;
	}

	@Override
	public String toString() {
		return "AnnouncementRequest [title=" + title + ", description=" + description + ", announcementDate="
				+ announcementDate + "]";
	}

}
