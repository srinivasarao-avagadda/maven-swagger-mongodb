package com.mphasis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  
  @Value("${spring.application.name}")
  private String name;

  @Autowired
  CarService carService;

  @GetMapping(value = "/ping")
  public @ResponseBody String respondToPing() {
    long ts = System.currentTimeMillis();
    LOG.info("Login Controller pinged. ts:" + ts);
    return name + " -- responding to ping at " + ts;
  }

  @ApiOperation(value = "creates a car", notes = "based on reponsebody as input it creates car document")
  @PostMapping(value = "/create")
  @ResponseStatus(HttpStatus.CREATED)
  public void createCar(@RequestBody Car car) {
    LOG.info("Saving Car.");
    carService.create(car);
  }

  @ApiOperation(value = "get a car", notes = "get a car")
  @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid car supplied"),
    @ApiResponse(code = 404, message = "Car not found")})
  @GetMapping(value = "/get", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody Car getCarByModel(@ApiParam(value = "car id value", required = false, defaultValue = "1")  @RequestParam String id,
    @ApiParam(value = "car model value", required = false, defaultValue = "dzire")  @RequestParam String model,
    @ApiParam(value = "car brand value", required = false, defaultValue = "maruthi suzuki")  @RequestParam String brand) {
    LOG.info("Get Car.");
    if (id != null) {
      return carService.findById(id);
    }
    else if (model != null) {
      return carService.findByModel(model);
    }
    else if (brand != null) {
      return carService.findByBrand(brand); 
    }
    return null;
  }

  @ApiOperation(value = "update a car", notes = "update a car")
  @PutMapping(value = "/update", consumes  = "application/json")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCar(@ApiParam(value = "Updated car object", required = true) @RequestBody Car car) {
    LOG.info("Put a Car.");
    carService.update(car);
  }

  @ApiOperation(value = "delete a car", notes = "update a car")
  @DeleteMapping(value = "/delete", consumes  = "application/json")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public void deleteCar(@RequestBody Car car) {
    LOG.info("Put a Car.");
    carService.delete(car);
  }

  @ApiOperation(value = "delete a car", notes = "update a car")
  @DeleteMapping(value = "/deleteAll")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public void deleteAllCars() {
    LOG.info("Delete all cars.");
    carService.deleteAll();
  }

}
