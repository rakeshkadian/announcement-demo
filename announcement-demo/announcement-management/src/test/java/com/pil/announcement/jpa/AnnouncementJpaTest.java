/**
 * 
 */
package com.pil.announcement.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.pil.announcement.entity.Announcement;
import com.pil.announcement.repository.AnnouncementRepository;

/**
 * @author Rakesh kadian
 *
 */
public class AnnouncementJpaTest extends BaseJpaTest {

	@Autowired
	private AnnouncementRepository announcementRepository;

	String title = "The Hurry-Up Limited Offer";

	@Before
	public void baseAnnouncementEntity() {
		Announcement announcement = new Announcement(title, "You will get 10 percent off on weekend.", new Date());
		announcement = announcementRepository.save(announcement);
		assertNotNull(announcement);
		assertNotNull(announcement.getId());
	}

	@Test
	public void createAnnouncement() {
		Announcement announcement = new Announcement("New Title", "You will get 10 percent off on weekend.",
				new Date());
		announcement = announcementRepository.save(announcement);
		assertNotNull(announcement);
		assertNotNull(announcement.getId());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void shouldFAILForDuplicateAnnouncement() {
		// try to insert duplicate announcement
		Announcement announcement = new Announcement(title, "You will get 10 percent off on weekend.", new Date());
		announcement = announcementRepository.save(announcement);
	}

	@Test
	public void getAllAnnouncements() {
		List<Announcement> announcements = announcementRepository.findAll();
		assertNotNull(announcements);
		assertTrue(announcements.size() >= 1);
	}

	@Test
	public void getByTitle() {
		Announcement announcementDb = announcementRepository.findByTitle(title);
		assertNotNull(announcementDb);
		assertEquals(title, announcementDb.getTitle());
	}

}
