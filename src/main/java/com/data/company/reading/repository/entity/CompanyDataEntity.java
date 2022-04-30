package com.data.company.reading.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "company_data")
public class CompanyDataEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "registered_date")
  private LocalDate registeredDate;

  @Column(name = "company_form")
  private String companyForm;

  @Column(name = "status_name")
  private String statusName;

  @Column(name = "status_since_date")
  private LocalDate statusSinceDate;

  @Column(name = "formatted_information_date")
  private LocalDate formattedInformationDate;

}
