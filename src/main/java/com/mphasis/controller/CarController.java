package com.mphasis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.entity.Car;
import com.mphasis.service.CarService;

@RestController
@RequestMapping(value = "/")
public class CarController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CarService carService;

	@PostMapping(value = "/create")
	public void createCar(@RequestBody Car car) {
		LOG.info("Saving Car.");
    carService.create(car);
	}
	
	
}