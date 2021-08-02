/**
 * 
 */
package com.pil.announcement.controller;

import static com.pil.announcement.util.ApiPathConstant.CREATE_ANNOUNCEMENT_URI;
import static com.pil.announcement.util.ApiPathConstant.RETRIEVE_ANNOUNCEMENT_URI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pil.announcement.core.response.DataEnvelope;
import com.pil.announcement.core.response.Response;
import com.pil.announcement.core.response.ResponseStatus;
import com.pil.announcement.request.AnnouncementRequest;
import com.pil.announcement.service.AnnouncementService;

/**
 * @author Rakesh kadian
 *
 */
@RestController
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;

	@PostMapping(value = CREATE_ANNOUNCEMENT_URI)
	public ResponseEntity<Response> createAnnouncement(@Valid @RequestBody AnnouncementRequest announcementRequest,
			HttpServletRequest httpServletRequest) {

		Response applicationResponse = Response.status(ResponseStatus.SUCCESS, HttpStatus.CREATED.value(),
				"Announcement created successfully", httpServletRequest.getRequestURI());

		announcementService.createAnnouncement(announcementRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponse);
	}

	@GetMapping(value = RETRIEVE_ANNOUNCEMENT_URI)
	public ResponseEntity<Response> retrieveAnnouncements(HttpServletRequest httpServletRequest) {

		Response applicationResponse = Response.status(ResponseStatus.SUCCESS, HttpStatus.OK.value(),
				"Retrieved Announcements successfully", httpServletRequest.getRequestURI());

		List<DataEnvelope> response = announcementService.retrieveAllAnnouncements();
		applicationResponse.data(response);

		return ResponseEntity.status(HttpStatus.OK).body(applicationResponse);

	}

}
