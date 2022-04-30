package com.data.company.companyData.service;

import com.data.company.companyData.model.CompanyData;
import com.data.company.companyData.repository.CompanyCommandRepository;
import com.data.company.shared.CellReader;
import com.data.company.shared.FileExtractor;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyCommandService {

  private final CompanyCommandRepository commandRepository;

  @Transactional
  public void exportFromExcelCompanyData() throws IOException {
    Workbook workbook = FileExtractor.readExcelFile("src/main/resources/imones.xlsx");
    Sheet sheet = workbook.getSheetAt(0);

    for (Row row : sheet) {

      if (row.getRowNum() == 0) {

        continue;
      }
      log.info("Collecting information from row.");
      String companyCode = CellReader.readValue(row, "JA_kodas", workbook);
      String companyName = CellReader.readValue(row, "JA_pavadinimas", workbook);
      String address = CellReader.readValue(row, "adresas", workbook);
      String registeredDate = CellReader.readValue(row, "reg_data", workbook);
      String formName = CellReader.readValue(row, "form_pavadinimas", workbook);
      String statusName = CellReader.readValue(row, "stat_pavadinimas", workbook);
      String statusSinceDate = CellReader.readValue(row, "stat_data_nuo", workbook);
      String formattedInformationDate = CellReader.readValue(row, "formavimo_data", workbook);

      CompanyData data = new CompanyData();
      data.setId(UUID.randomUUID());
      data.setCode(companyCode);
      data.setName(companyName);
      data.setAddress(address);
      data.setRegisteredDate(LocalDate.parse(registeredDate));
      data.setCompanyForm(formName);
      data.setStatusName(statusName);
      data.setStatusSinceDate(LocalDate.parse(statusSinceDate));
      data.setFormattedInformationDate(LocalDate.parse(formattedInformationDate));
      log.info("Saving data.");
      commandRepository.save(data);

    }
  }

}
