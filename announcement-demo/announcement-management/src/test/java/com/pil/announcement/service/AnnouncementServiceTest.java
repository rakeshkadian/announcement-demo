/**
 * 
 */
package com.pil.announcement.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pil.announcement.application.AnnouncementApplication;
import com.pil.announcement.configuration.TestConfig;
import com.pil.announcement.core.response.DataEnvelope;
import com.pil.announcement.exception.DuplicateAnnouncementException;
import com.pil.announcement.request.AnnouncementRequest;

/**
 * @author Rakesh kadian
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AnnouncementApplication.class, TestConfig.class })
@Transactional
public class AnnouncementServiceTest {

	@Autowired
	private AnnouncementService announcementService;

	private AnnouncementRequest announcementRequest() {
		return new AnnouncementRequest("The Hurry-Up Limited Offer", "You will get 10 percent off on weekend.",
				new Date());
	}

	@Test
	public void createAnnouncement() {
		AnnouncementRequest announcementRequest = announcementRequest();
		announcementService.createAnnouncement(announcementRequest);
	}

	@Test(expected = DuplicateAnnouncementException.class)
	public void shouldFAILForDuplicateAnnouncement() {
		createAnnouncement();
		// try to insert announcement with same title
		AnnouncementRequest announcementRequest = announcementRequest();
		announcementService.createAnnouncement(announcementRequest);
	}

	@Test
	public void retrieveAnnouncements() {
		createAnnouncement();
		List<DataEnvelope> announcements = announcementService.retrieveAllAnnouncements();
		assertNotNull(announcements);
		assertTrue(announcements.size() >= 1);
	}

}
