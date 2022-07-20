package com.data.company.shop.laptops.repository.converter;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.entity.LaptopEntity;
import org.springframework.stereotype.Component;

@Component
public class LaptopConverter {

  public LaptopEntity convertToEntity(Laptop laptop) {
    return new LaptopEntity()
        .setId(laptop.getId())
        .setName(laptop.getName())
        .setPicture(laptop.getPicture())
        .setProductCode(laptop.getProductCode())
        .setPrice(laptop.getPrice())
        .setProductType(laptop.getProductType())
        .setProductCreator(laptop.getProductCreator())
        .setSeries(laptop.getSeries())
        .setModel(laptop.getModel())
        .setComputerType(laptop.getComputerType())
        .setWeight(laptop.getWeight())
        .setLength(laptop.getLength())
        .setScreenSize(laptop.getScreenSize())
        .setScreenResolution(laptop.getScreenResolution())
        .setOperationalSystem(laptop.getOperationalSystem())
        .setProcessorClass(laptop.getProcessorClass())
        .setProcessorType(laptop.getProcessorType())
        .setRamType(laptop.getRamType())
        .setAmountOfRam(laptop.getAmountOfRam())
        .setMaxAmountOfRam(laptop.getMaxAmountOfRam())
        .setDataStorageType(laptop.getDataStorageType())
        .setDataStorageSize(laptop.getDataStorageSize())
        .setGraphicsCardType(laptop.getGraphicsCardType())
        .setGraphicsCardSeries(laptop.getGraphicsCardSeries())
        .setGraphicsCardModel(laptop.getGraphicsCardModel())
        .setGraphicsCardMemorySize(laptop.getGraphicsCardMemorySize())
        .setVideoCamera(laptop.getVideoCamera())
        .setIntegratedMicrophone(laptop.getIntegratedMicrophone())
        .setKeyboardLanguage(laptop.getKeyboardLanguage())
        .setCategory(laptop.getCategory())
        .setComputerAndOfficeCategory(laptop.getComputerAndOfficeCategory());
  }

  public Laptop convertFromEntity(LaptopEntity entity) {
    return new Laptop()
    .setId(entity.getId())
    .setName(entity.getName())
    .setPicture(entity.getPicture())
    .setProductCode(entity.getProductCode())
    .setPrice(entity.getPrice())
    .setProductType(entity.getProductType())
    .setProductCreator(entity.getProductCreator())
    .setSeries(entity.getSeries())
    .setModel(entity.getModel())
    .setComputerType(entity.getComputerType())
    .setWeight(entity.getWeight())
    .setLength(entity.getLength())
    .setScreenSize(entity.getScreenSize())
    .setScreenResolution(entity.getScreenResolution())
    .setOperationalSystem(entity.getOperationalSystem())
    .setProcessorClass(entity.getProcessorClass())
    .setProcessorType(entity.getProcessorType())
    .setRamType(entity.getRamType())
    .setAmountOfRam(entity.getAmountOfRam())
    .setMaxAmountOfRam(entity.getMaxAmountOfRam())
    .setDataStorageType(entity.getDataStorageType())
    .setDataStorageSize(entity.getDataStorageSize())
    .setGraphicsCardType(entity.getGraphicsCardType())
    .setGraphicsCardSeries(entity.getGraphicsCardSeries())
    .setGraphicsCardModel(entity.getGraphicsCardModel())
    .setGraphicsCardMemorySize(entity.getGraphicsCardMemorySize())
    .setVideoCamera(entity.getVideoCamera())
    .setIntegratedMicrophone(entity.getIntegratedMicrophone())
    .setKeyboardLanguage(entity.getKeyboardLanguage())
    .setCategory(entity.getCategory())
    .setComputerAndOfficeCategory(entity.getComputerAndOfficeCategory());
  }
}
