/**
 * 
 */
package com.pil.announcement.application.mvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rakesh kadian
 *
 */
@Transactional
public class AnnouncementControllerTest extends BaseMvcTest {

	@Test
	public void createAnnouncement() throws IOException, Exception {
		RequestBuilder request = retrieveRequest("create-announcement-req.json", HttpMethod.POST, "/announcement");
		mvc.perform(request).andExpect(status().is(HttpStatus.CREATED.value()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
	}
	
	@Test
	public void shouldFAILForDuplicateAnnouncement() throws IOException, Exception {
		createAnnouncement();
		// try to insert announcement with same title
		RequestBuilder request = retrieveRequest("create-announcement-req.json", HttpMethod.POST, "/announcement");
		mvc.perform(request).andExpect(status().is(HttpStatus.CONFLICT.value()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
	}
	
	@Test
	public void retrieveAnnouncements() throws IOException, Exception {
		createAnnouncement();
		
		RequestBuilder request = retrieveRequest(null, HttpMethod.GET, "/announcement");
		mvc.perform(request).andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
	}

}
