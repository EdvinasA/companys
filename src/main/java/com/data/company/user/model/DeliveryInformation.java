package com.data.company.user.model;

import lombok.Data;

@Data
public class DeliveryInformation {

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String city;
  private String postalCode;

  private String companyCode;
  private String companyName;
  private String companyPVMCode;
  private String companyAddress;
}
