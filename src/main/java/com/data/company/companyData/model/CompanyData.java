package com.data.company.companyData.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate registeredDate;

  private String companyForm;

  private String statusName;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate statusSinceDate;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate formattedInformationDate;

}
