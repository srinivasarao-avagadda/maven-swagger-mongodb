package com.mphasis.service;

import java.util.List;
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
 
    @Override
    public void create(Car car) {
        Car c = carRepo.insert(car);
        LOGGER.info("Created:- " + c);
    }
 
    @Override
    public void update(Car car) {
        Car c = carRepo.save(car);
        LOGGER.info("Updated:- " + c);
 
    }
 
    @Override
    public void delete(Car car) {
        carRepo.delete(car);
        LOGGER.info("Deleted:- " + car.getId());
    }
 
    @Override
    public List < Car > findAll() {
        return carRepo.findAll();
    }
 
    @Override
    public List < Car > findByBrand(String brand) {
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
 
    @Override
    public void deleteAll() {
        carRepo.deleteAll();
    }
}
