package com.mphasis.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.entity.Car;
import com.mphasis.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

  private final Logger LOGGER = LoggerFactory.getLogger(getClass());

  @Autowired
  CarRepository carRepo;

  /** create car*/
  @Override
  public void create(Car car) {
    carRepo.save(car);
    LOGGER.info("Created: " + car);
  }

  /** find car*/
  
  @Override
  public Car findById(String id) {
    return carRepo.findById(id).get();
  }
  
  @Override
  public Car findByBrand(String brand) {
    return carRepo.findByBrand(brand);
  }

  @Override
  public Car findByModel(String model) {
    return carRepo.findByModel(model);
  }

  @Override
  public Optional<Car> find(Car car) {
    return carRepo.findById(car.getId());
  }

  /** update car*/
  @Override
  public Car update(Car car) {
    Car c = carRepo.save(car);
    LOGGER.info("Updated: " + c);
    return c;
  }

  /** delete car*/
  @Override
  public void delete(Car car) {
    carRepo.delete(car);
    LOGGER.info("Deleted: " + car.getId());
  }

  @Override
  public void deleteAll() {
    carRepo.deleteAll();
    LOGGER.info("Deleted everthing");
  }
}
