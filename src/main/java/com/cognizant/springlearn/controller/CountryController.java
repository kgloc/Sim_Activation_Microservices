package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.repository.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public Country getCountryIndia() {

		Country country = (Country) context.getBean("in");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {

		List<Country> countryList = (ArrayList) context.getBean("countryList");
		return countryList;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

		Country country = countryService.getCountry(code);
		return country;
	}
}
