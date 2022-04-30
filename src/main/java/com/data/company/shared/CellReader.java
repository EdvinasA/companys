package com.data.company.shared;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CellReader {

  public static String readValue(Row row, String column, Workbook workbook) {
    Map<String, Integer> columnIndexMap = getColumnIndexMap(workbook.getSheetAt(0));
    Integer cellIndex = columnIndexMap.get(column);
    Cell cell = row.getCell(cellIndex, MissingCellPolicy.CREATE_NULL_AS_BLANK);

    return CellParser.readCellValue(cell);
  }

  private static Map<String, Integer> getColumnIndexMap(Sheet sheet) {
    Map<String, Integer> map = new HashMap<>();
    Row row = sheet.getRow(0);

    if (Objects.nonNull(row)) {
      for (Cell cell : row) {
        String col = CellParser.readCellValue(cell);

        if (Objects.nonNull(col)) {
          map.put(col, cell.getColumnIndex());
        }
      }
    }
    return map;
  }

}
