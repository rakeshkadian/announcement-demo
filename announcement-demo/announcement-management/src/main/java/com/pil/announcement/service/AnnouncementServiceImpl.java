/**
 * 
 */
package com.pil.announcement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pil.announcement.core.response.DataEnvelope;
import com.pil.announcement.entity.Announcement;
import com.pil.announcement.exception.DuplicateAnnouncementException;
import com.pil.announcement.repository.AnnouncementRepository;
import com.pil.announcement.request.AnnouncementRequest;
import com.pil.announcement.response.AnnouncementResponse;

/**
 * @author Rakesh kadian
 *
 */
@Service("announcementServiceImpl")
public class AnnouncementServiceImpl implements AnnouncementService {

	private final Logger LOGGER = LoggerFactory.getLogger(AnnouncementServiceImpl.class);

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AnnouncementRepository announcementRepository;

	@Transactional
	@Override
	public void createAnnouncement(final AnnouncementRequest announcementRequest) {
		final String title = announcementRequest.getTitle();
		Announcement announcement = announcementRepository.findByTitle(title);
		if (null != announcement) {
			String errorMsg = String.format("Announcement with title %s already exist in the system.", title);
			LOGGER.error(errorMsg);
			throw new DuplicateAnnouncementException(errorMsg);
		}
		announcement = modelMapper.map(announcementRequest, Announcement.class);
		announcementRepository.save(announcement);
	}

	@Override
	public List<DataEnvelope> retrieveAllAnnouncements() {
		List<Announcement> announcements = announcementRepository.findAll();
		List<DataEnvelope> response = announcements.stream()
				.map(announcement -> modelMapper.map(announcement, AnnouncementResponse.class))
				.collect(Collectors.toList());
		return response;
	}

}
