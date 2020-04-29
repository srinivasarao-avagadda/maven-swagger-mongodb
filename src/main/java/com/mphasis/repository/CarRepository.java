package com.mphasis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
  Car findByModel(String model);
  List<Car> findByBrand(String brand);
}
