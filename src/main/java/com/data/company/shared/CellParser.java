package com.data.company.shared;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

public class CellParser {

  public static String readCellValue(Cell cell) {
    String value;

    switch (cell.getCellType()) {
      case NUMERIC:
        value = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
        break;
      case STRING:
        value = cell.getStringCellValue();
        break;
      default:
        value = null;
        break;
    }
    return StringUtils.trimToEmpty(value);
  }
}
