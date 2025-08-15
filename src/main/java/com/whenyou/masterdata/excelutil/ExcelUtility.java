package com.whenyou.masterdata.excelutil;

import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.entity.MPincode;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {
    public static List<MDistrict> excelToDistricts(InputStream is) {
        List<MDistrict> districts = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                // Skip header
                if (rowNumber++ == 0) continue;
                // Skip empty rows
                if (isRowEmpty(row)) continue;
                MDistrict district = new MDistrict();
                // Excel ID
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        district.setExcelId(Long.parseLong(idStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid Excel ID at row " + rowNumber + ": " + idStr);
                    }
                }
                // Name
                district.setName(getCellValueAsString(row.getCell(1)));
                // Name in Local
                district.setNameInLocal(getCellValueAsString(row.getCell(2)));
                // Status
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    district.setStatus(Boolean.parseBoolean(statusStr));
                }
                districts.add(district);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage(), e);
        }
        return districts;
    }

    // Utility method to check if a row is empty
    private static boolean isRowEmpty(Row row) {
        if (row == null) return true;
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public static List<MPincode> excelToPincodes(InputStream is) throws IOException {
        List<MPincode> pincodes = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue; // Skip header row
                if (isRowEmpty(row)) continue;
                MPincode pincode = new MPincode();
                // Excel ID (Long)
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        pincode.setExcelId(Long.parseLong(idStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid Excel ID at row " + rowNumber + ": " + idStr);
                    }
                }
                pincode.setName(getCellValueAsString(row.getCell(1)));
                pincode.setNameInLocal(getCellValueAsString(row.getCell(2)));
                pincode.setPincode(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    pincode.setStatus(Boolean.parseBoolean(statusStr));
                }
                pincodes.add(pincode);
            }
        }
        return pincodes;
    }

    /**
     * Convert any cell to String safely.
     */
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                double numericValue = cell.getNumericCellValue();
                if (numericValue == (long) numericValue) {
                    return String.valueOf((long) numericValue); // Remove .0
                } else {
                    return String.valueOf(numericValue);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getRichStringCellValue().getString().trim();
            case BLANK:
            default:
                return null;
        }
    }

//    public static List<Car> excelToCars(InputStream is) throws IOException {
//        Workbook workbook = new XSSFWorkbook(is);
//        Sheet sheet = workbook.getSheetAt(0);
//        List<Car> cars = new ArrayList<>();
//        Iterator<Row> rows = sheet.iterator();
//        int rowNumber = 0;
//        while (rows.hasNext()) {
//            Row row = rows.next();
//            if (rowNumber++ == 0) continue; // Skip header
//    if (row == null) continue;
//            Car car = new Car();
//            car.setId((long) row.getCell(0).getNumericCellValue());
//            car.setModel(row.getCell(1).getStringCellValue());
//            car.setBrand(row.getCell(2).getStringCellValue());
//            car.setPincode(row.getCell(3).getStringCellValue());
//            car.setStatus(row.getCell(4).getBooleanCellValue());
//            cars.add(car);
//        }
//        workbook.close();
//        return cars;
//    }
}
