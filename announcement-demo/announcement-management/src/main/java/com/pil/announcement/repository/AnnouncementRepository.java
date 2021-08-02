/**
 * 
 */
package com.pil.announcement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pil.announcement.entity.Announcement;

/**
 * @author Rakesh kadian
 *
 */
public interface AnnouncementRepository extends CrudRepository<Announcement, Integer> {

	/**
	 * This function is used to retrieve all the announcements from the database
	 * 
	 */
	public List<Announcement> findAll();

	/**
	 * This function is used to retrieve the announcement for title
	 * 
	 * @param title
	 * @return
	 */
	public Announcement findByTitle(final String title);

}
