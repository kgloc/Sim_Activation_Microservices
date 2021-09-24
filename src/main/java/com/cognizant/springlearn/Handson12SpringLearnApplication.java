package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.repository.Country;

@SpringBootApplication(scanBasePackages = "com.cognizant.springlearn")
public class Handson12SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson12SpringLearnApplication.class);

	private static void displayDate() {

		LOGGER.debug("---Starting 'displayDate' Method---");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = (SimpleDateFormat) context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Date: {}", date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.debug("---Ending 'displayDate' Method---");
	}

	private static void displayCountry() {

		LOGGER.debug("---Starting 'displayCountry' Method---");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		Country anotherCountry = (Country) context.getBean("in", Country.class);
		LOGGER.debug("Country: {}", country.toString());
		LOGGER.debug("---Ending 'displayDate' Method---");
	}

	private static void displayCountries() {

		LOGGER.debug("---Starting 'displayCountries' Method---");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
		countryList.forEach(c -> LOGGER.debug(c.getCode() + " - " + c.getName()));
		LOGGER.debug("---Ending 'displayCountries' Method---");
	}

	public static void main(String[] args) {

		LOGGER.debug("***Inside 'main' Method***");
		SpringApplication.run(Handson12SpringLearnApplication.class, args);

		displayDate();
		displayCountry();
		displayCountries();
	}
}
