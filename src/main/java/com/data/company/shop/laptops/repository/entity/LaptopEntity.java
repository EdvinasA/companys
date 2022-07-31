package com.data.company.shop.laptops.repository.entity;

import com.data.company.shop.shared.Category;
import com.data.company.shop.shared.ComputerAndOfficeCategory;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopEntity {

  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "picture")
  private String picture;

  @Column(name = "product_code")
  private String productCode;

  @Column(name = "price")
  private double price;

  @Column(name = "product_type")
  private String productType;

  @Column(name = "product_creator")
  private String productCreator;

  @Column(name = "series")
  private String series;

  @Column(name = "model")
  private String model;

  @Column(name = "computer_type")
  private String computerType;

  @Column(name = "weight")
  private String weight;

  @Column(name = "length")
  private String length;

  @Column(name = "screen_size")
  private String screenSize;

  @Column(name = "screen_resolution")
  private String screenResolution;

  @Column(name = "operational_system")
  private String operationalSystem;

  @Column(name = "processor_class")
  private String processorClass;

  @Column(name = "processor_type")
  private String processorType;

  @Column(name = "ram_type")
  private String ramType;

  @Column(name = "amount_of_ram")
  private String amountOfRam;

  @Column(name = "max_amount_of_ram")
  private String maxAmountOfRam;

  @Column(name = "data_storage_type")
  private String dataStorageType;

  @Column(name = "data_storage_size")
  private String dataStorageSize;

  @Column(name = "graphics_card_type")
  private String graphicsCardType;

  @Column(name = "graphics_card_series")
  private String graphicsCardSeries;

  @Column(name = "graphics_card_model")
  private String graphicsCardModel;

  @Column(name = "graphics_card_memory_size")
  private String graphicsCardMemorySize;

  @Column(name = "video_camera")
  private Boolean videoCamera;

  @Column(name = "integrated_microphone")
  private Boolean integratedMicrophone;

  @Column(name = "keyboard_language")
  private String keyboardLanguage;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(name = "computer_and_office_category")
  @Enumerated(EnumType.STRING)
  private ComputerAndOfficeCategory computerAndOfficeCategory;

  @Column(name = "stripe_product_id")
  private String stripeProductId;
}
