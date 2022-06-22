package com.data.company.shop.laptops.repository.converter;

import com.data.company.shop.laptops.model.Laptop;
import com.data.company.shop.laptops.repository.entity.LaptopEntity;
import org.springframework.stereotype.Component;

@Component
public class LaptopConverter {

  public LaptopEntity convertToEntity(Laptop laptop) {
    LaptopEntity entity = new LaptopEntity();
    entity.setId(laptop.getId());
    entity.setName(laptop.getName());
    entity.setPicture(laptop.getPicture());
    entity.setProductCode(laptop.getProductCode());
    entity.setPrice(laptop.getPrice());
    entity.setProductType(laptop.getProductType());
    entity.setProductCreator(laptop.getProductCreator());
    entity.setSeries(laptop.getSeries());
    entity.setModel(laptop.getModel());
    entity.setComputerType(laptop.getComputerType());
    entity.setWeight(laptop.getWeight());
    entity.setLength(laptop.getLength());
    entity.setScreenSize(laptop.getScreenSize());
    entity.setScreenResolution(laptop.getScreenResolution());
    entity.setOperationalSystem(laptop.getOperationalSystem());
    entity.setProcessorClass(laptop.getProcessorClass());
    entity.setProcessorType(laptop.getProcessorType());
    entity.setRamType(laptop.getRamType());
    entity.setAmountOfRam(laptop.getAmountOfRam());
    entity.setMaxAmountOfRam(laptop.getMaxAmountOfRam());
    entity.setDataStorageType(laptop.getDataStorageType());
    entity.setDataStorageSize(laptop.getDataStorageSize());
    entity.setGraphicsCardType(laptop.getGraphicsCardType());
    entity.setGraphicsCardSeries(laptop.getGraphicsCardSeries());
    entity.setGraphicsCardModel(laptop.getGraphicsCardModel());
    entity.setGraphicsCardMemorySize(laptop.getGraphicsCardMemorySize());
    entity.setVideoCamera(laptop.getVideoCamera());
    entity.setIntegratedMicrophone(laptop.getIntegratedMicrophone());
    entity.setKeyboardLanguage(laptop.getKeyboardLanguage());
    entity.setCategory(laptop.getCategory());
    entity.setComputerAndOfficeCategory(laptop.getComputerAndOfficeCategory());
    return entity;
  }

  public Laptop convertFromEntity(LaptopEntity entity) {
    Laptop object = new Laptop();
    object.setId(entity.getId());
    object.setName(entity.getName());
    object.setPicture(entity.getPicture());
    object.setProductCode(entity.getProductCode());
    object.setPrice(entity.getPrice());
    object.setProductType(entity.getProductType());
    object.setProductCreator(entity.getProductCreator());
    object.setSeries(entity.getSeries());
    object.setModel(entity.getModel());
    object.setComputerType(entity.getComputerType());
    object.setWeight(entity.getWeight());
    object.setLength(entity.getLength());
    object.setScreenSize(entity.getScreenSize());
    object.setScreenResolution(entity.getScreenResolution());
    object.setOperationalSystem(entity.getOperationalSystem());
    object.setProcessorClass(entity.getProcessorClass());
    object.setProcessorType(entity.getProcessorType());
    object.setRamType(entity.getRamType());
    object.setAmountOfRam(entity.getAmountOfRam());
    object.setMaxAmountOfRam(entity.getMaxAmountOfRam());
    object.setDataStorageType(entity.getDataStorageType());
    object.setDataStorageSize(entity.getDataStorageSize());
    object.setGraphicsCardType(entity.getGraphicsCardType());
    object.setGraphicsCardSeries(entity.getGraphicsCardSeries());
    object.setGraphicsCardModel(entity.getGraphicsCardModel());
    object.setGraphicsCardMemorySize(entity.getGraphicsCardMemorySize());
    object.setVideoCamera(entity.getVideoCamera());
    object.setIntegratedMicrophone(entity.getIntegratedMicrophone());
    object.setKeyboardLanguage(entity.getKeyboardLanguage());
    object.setCategory(entity.getCategory());
    object.setComputerAndOfficeCategory(entity.getComputerAndOfficeCategory());
    return object;
  }
}
