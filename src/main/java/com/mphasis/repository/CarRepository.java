package com.mphasis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.entity.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
  Car findByModel(String model);
  List<Car> findByBrand(String brand);
}
