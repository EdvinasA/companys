package com.data.company.companyData.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyData {

  @Id
  private UUID id;

  private String code;

  private String name;

  private String address;

  private LocalDate registeredDate;

  private String companyForm;

  private String statusName;

  private LocalDate statusSinceDate;

  private LocalDate formattedInformationDate;

}
