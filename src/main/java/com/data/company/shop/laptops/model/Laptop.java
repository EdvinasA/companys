package com.data.company.shop.laptops.model;

import java.util.UUID;
import lombok.Data;

@Data
public class Laptop {

  private UUID id;
  private String name;
  private String picture;
  private String productCode;
  private double price;
  private String productType;
  private String productCreator;
  private String series;
  private String model;
  private String computerType;
  private String weight;
  private String length;
  private String screenSize;
  private String screenResolution;
  private String operationalSystem;
  private String processorClass;
  private String processorType;
  private String ramType;
  private String amountOfRam;
  private String maxAmountOfRam;
  private String dataStorageType;
  private String dataStorageSize;
  private String graphicsCardType;
  private String graphicsCardSeries;
  private String graphicsCardModel;
  private String graphicsCardMemorySize;
  private Boolean videoCamera;
  private Boolean integratedMicrophone;
  private String keyboardLanguage;

}
