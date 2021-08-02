/**
 * 
 */
package com.pil.announcement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Rakesh kadian
 *
 */
@Entity
@Table(name = "announcement", catalog = "announcement_management")
public class Announcement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109314521909374753L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "title", nullable = false, unique = true)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "announcement_date", nullable = false)
	private Date announcementDate;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	private Date createTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	private Date updateTime;

	/**
	 * Default constructor
	 */
	public Announcement() {

	}

	public Announcement(String title, String description, Date announcementDate) {
		this.title = title;
		this.description = description;
		this.announcementDate = announcementDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", description=" + description + ", announcementDate="
				+ announcementDate + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
