/**
 * 
 */
package com.pil.announcement.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Rakesh kadian
 *
 */
@SpringBootApplication(scanBasePackages = { "com.pil" })
public class AnnouncementApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		return objectMapper;
	}

	/**
	 * Function responsible for launching the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AnnouncementApplication.class, args);
	}

}
