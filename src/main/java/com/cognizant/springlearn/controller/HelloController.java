package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*
	 * private static final Logger LOGGER =
	 * LoggerFactory.getLogger(HelloController.class);
	 */

	@GetMapping("/hello")
	public String sayHello() {

		/* LOGGER.debug("---Executing 'sayHello' Method---"); */
		return "Hello World!!";
	}
}
