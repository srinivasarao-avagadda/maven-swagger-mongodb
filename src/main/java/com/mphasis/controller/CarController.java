package com.mphasis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.entity.Car;
import com.mphasis.service.CarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/car", description = "Operations about car")
@RestController
@RequestMapping(value = "/")
public class CarController {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

  @Autowired
  CarService carService;

  @GetMapping(value = "/ping")
  public @ResponseBody String respondToPing() {
    long ts = System.currentTimeMillis();
    LOG.info("Login Controller pinged. ts:" + ts);
    return "Login -- responding to ping at " + ts;
  }

  @ApiOperation(value = "creates a car", notes = "based on reponsebody as input it creates car document")
  @PostMapping(value = "/create")
  public Car createCar(@RequestBody Car car) {
    LOG.info("Saving Car.");
    return carService.create(car);
  }

  @ApiOperation(value = "get a car", notes = "get a car")
  @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid car supplied"),
    @ApiResponse(code = 404, message = "Car not found")})
  @GetMapping(value = "/get")
  public Car getCar(@RequestBody Car car) {
    LOG.info("Get Car.");
    return carService.find(car).get();
  }

  @ApiOperation(value = "update a car", notes = "update a car")
  @PutMapping(value = "/update")
  public void updateCar(@ApiParam(value = "Updated car object", required = true) @RequestBody Car car) {
    LOG.info("Put a Car.");
    carService.update(car);
  }

  @ApiOperation(value = "delete a car", notes = "update a car")
  @PutMapping(value = "/delete")
  public void deleteCar(@RequestBody Car car) {
    LOG.info("Put a Car.");
    carService.update(car);
  }

  @ApiOperation(value = "delete a car", notes = "update a car")
  @PutMapping(value = "/deleteAll")
  public void deleteAllCars(@RequestBody Car car) {
    LOG.info("Delete all cars.");
    carService.deleteAll();
  }

}
