package com.mphasis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
  Optional<Car> findById(String id);
  Car findByModel(String model);
  Car findByBrand(String brand);
}
