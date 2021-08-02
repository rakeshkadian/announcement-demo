/**
 * 
 */
package com.pil.announcement.application.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.pil.announcement.application.AnnouncementApplication;
import com.pil.announcement.configuration.TestConfig;

/**
 * @author Rakesh kadian
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AnnouncementApplication.class, TestConfig.class })
@AutoConfigureMockMvc
@Ignore
public class BaseMvcTest {

	@Autowired
	protected MockMvc mvc;

	protected RequestBuilder retrieveRequest(String requestDataFile, HttpMethod method, String endPoint,
			Object... pathParamValue) throws IOException, Exception {

		String requestData = null;

		if (null != requestDataFile) {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(requestDataFile);
			requestData = IOUtils.toString(is, Charset.defaultCharset());
		}

		RequestBuilder request = null;

		switch (method) {

		case POST:
			request = post(endPoint).contentType(MediaType.APPLICATION_JSON).content(requestData);
			break;

		case GET:
			request = get(endPoint, pathParamValue).accept(MediaType.APPLICATION_JSON);
			break;

		default:
			break;

		}
		return request;

	}
}
