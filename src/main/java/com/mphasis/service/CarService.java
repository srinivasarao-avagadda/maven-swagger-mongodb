package com.mphasis.service;

import java.util.Optional;

import com.mphasis.entity.Car;

public interface CarService {

  public void create(Car car);

  public Car update(Car car);

  public void delete(Car car);

  public void deleteAll();

  public Optional<Car> find(Car car);
  
  public Car findById(String id);

  public Car findByBrand(String brand);

  public Car findByModel(String model);
}
