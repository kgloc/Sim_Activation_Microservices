package com.cognizant.springlearn.repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Country {

	/*
	 * private static final Logger LOGGER =
	 * LoggerFactory.getLogger(Handson12SpringLearnApplication.class);
	 */

	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;

	/*
	 * public Country() { LOGGER.debug("***Inside 'Country' Constructor***");
	 * System.out.println(toString()); }
	 */
}
