package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.repository.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	List<Country> countryList = (ArrayList) context.getBean("countryList");

	public Country getCountry(String code) throws CountryNotFoundException {

		Country country = null;

		for (Country c : countryList) {
			if (c.getCode().equalsIgnoreCase(code)) {
				country = c;
			}
		}

		if (country == null)
			throw new CountryNotFoundException();
		else
			return country;
	}
}
