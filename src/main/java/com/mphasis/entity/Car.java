package com.mphasis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Car Model", description = "Car Model documentation")
@Data
@Document(collection = "cars")
public class Car {

  @ApiModelProperty(value = "car brand", example = "1")
  @Id
  private String id;

  @ApiModelProperty(value = "car brand", example = "maruthi suzuki")
  private String brand;

  @ApiModelProperty(value = "car model", example = "dzire")
  private String model;

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Id:- " + getId() + ", Brand:- " + getBrand() + ", Model:- " + getModel());
    return str.toString();
  }

}
