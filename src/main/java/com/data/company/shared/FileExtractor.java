package com.data.company.shared;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileExtractor {

  public static XSSFWorkbook readExcelFile(String fileName) throws IOException {
    IOUtils.setByteArrayMaxOverride(1000000000);
    FileInputStream file = new FileInputStream(fileName);

    return new XSSFWorkbook(file);
  }

}
