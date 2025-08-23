package in.com.whenyou.masterdata.excelutil;

import in.com.whenyou.masterdata.entity.*;
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
                if (rowNumber++ == 0) continue; // Skip header
                if (isRowEmpty(row)) continue; // Skip empty rows
                MDistrict district = new MDistrict();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        district.setDistrictId(Long.parseLong(idStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid District ID at row " + rowNumber + ": " + idStr);
                    }
                }
                district.setName(getCellValueAsString(row.getCell(1)));
                district.setNameInLocal(getCellValueAsString(row.getCell(2)));
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
                if (isRowEmpty(row)) continue; // Skip empty rows
                MPincode pincode = new MPincode();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        pincode.setPincodeId(Long.parseLong(idStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid Pincode ID at row " + rowNumber + ": " + idStr);
                    }
                }
                String districtIdStr = getCellValueAsString(row.getCell(1));
                if (districtIdStr != null && !districtIdStr.isEmpty()) {
                    try {
                        pincode.setDistrictId(Long.parseLong(districtIdStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid District ID at row " + rowNumber + ": " + idStr);
                    }
                }
                pincode.setName(getCellValueAsString(row.getCell(2)));
                pincode.setNameInLocal(getCellValueAsString(row.getCell(3)));
                pincode.setPincode(getCellValueAsString(row.getCell(4)));
                String statusStr = getCellValueAsString(row.getCell(5));
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

    public static List<MVehicleBrand> excelToVehicleBrands(InputStream is) throws IOException {
        List<MVehicleBrand> vehicles = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue; // Skip header row
                if (isRowEmpty(row)) continue; // Skip empty rows
                MVehicleBrand vehicle = new MVehicleBrand();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        vehicle.setBrandId(Long.parseLong(idStr));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid Excel ID at row " + rowNumber + ": " + idStr);
                    }
                }
                vehicle.setBrandName(getCellValueAsString(row.getCell(1)));
                vehicle.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    vehicle.setStatus(Boolean.parseBoolean(statusStr));
                }
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    // Vehicle Model Type
    public static List<MVehicleModelType> excelToVehicleModelTypes(InputStream is) throws IOException {
        List<MVehicleModelType> vehicleModels = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MVehicleModelType vehicleModel = new MVehicleModelType();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    vehicleModel.setModelTypeId(Long.parseLong(idStr));
                }
                vehicleModel.setModelTypeName(getCellValueAsString(row.getCell(1)));
                vehicleModel.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    vehicleModel.setStatus(Boolean.parseBoolean(statusStr));
                }                vehicleModels.add(vehicleModel);
            }
        }
        return vehicleModels;
    }

    // Vehicle Model Name
    public static List<MVehicleModelName> excelToVehicleModelNames(InputStream is) throws IOException {
        List<MVehicleModelName> vehicleModelNames = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MVehicleModelName vehicleModelName = new MVehicleModelName();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    vehicleModelName.setModelNameId(Long.parseLong(idStr));
                }
                vehicleModelName.setBrandId(Long.parseLong(getCellValueAsString(row.getCell(1))));
                vehicleModelName.setModelTypeId(Long.parseLong(getCellValueAsString(row.getCell(2))));
                vehicleModelName.setModelName(getCellValueAsString(row.getCell(3)));
                vehicleModelName.setNameInLocal(getCellValueAsString(row.getCell(4)));
                String statusStr = getCellValueAsString(row.getCell(5));
                if (statusStr != null && !statusStr.isEmpty()) {
                    vehicleModelName.setStatus(Boolean.parseBoolean(statusStr));
                }                vehicleModelNames.add(vehicleModelName);
            }
        }
        return vehicleModelNames;
    }

    // Jewel Product Type
    public static List<MJewelProductType> excelToJewels(InputStream is) throws IOException {
        List<MJewelProductType> jewels = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue; // Skip header
                if (isRowEmpty(row)) continue;

                MJewelProductType jewel = new MJewelProductType();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    jewel.setJewelProductTypeId(Long.parseLong(idStr));
                }
                jewel.setProductTypeName(getCellValueAsString(row.getCell(1)));
                jewel.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    jewel.setStatus(Boolean.parseBoolean(statusStr));
                }
                jewels.add(jewel);
            }
        }
        return jewels;
    }

    public static List<MJewelMaterial> excelToJewelMaterials(InputStream is) throws IOException {
        List<MJewelMaterial> jewelMaterials = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue; // Skip header
                if (isRowEmpty(row)) continue;

                MJewelMaterial jewelMaterial = new MJewelMaterial();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    jewelMaterial.setJewelMaterialId(Long.parseLong(idStr));
                }
                jewelMaterial.setMaterialName(getCellValueAsString(row.getCell(1)));
                jewelMaterial.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    jewelMaterial.setStatus(Boolean.parseBoolean(statusStr));
                }
                jewelMaterials.add(jewelMaterial);
            }
        }
        return jewelMaterials;
    }

    // Material Purity
    public static List<MJewelMaterialPurity> excelToJewelMaterialPurities(InputStream is) throws IOException {
        List<MJewelMaterialPurity> purities = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue; // Skip header
                if (isRowEmpty(row)) continue;

                MJewelMaterialPurity purity = new MJewelMaterialPurity();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    purity.setJewelMaterialPurityId(Long.parseLong(idStr));
                }
                String jewelMaterialIdStr = getCellValueAsString(row.getCell(1));
                if (jewelMaterialIdStr != null && !jewelMaterialIdStr.isEmpty()) {
                    purity.setJewelMaterialId(Long.parseLong(jewelMaterialIdStr));
                }
                purity.setMaterialPurity(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    purity.setStatus(Boolean.parseBoolean(statusStr));
                }
                purities.add(purity);
            }
        }
        return purities;
    }

    public static List<MServeType> excelToServeTypes(InputStream is) throws IOException {
        List<MServeType> serveTypes = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MServeType serveType = new MServeType();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    serveType.setServeTypeId(Long.parseLong(idStr));
                }
                serveType.setServeType(getCellValueAsString(row.getCell(1)));
                serveType.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    serveType.setStatus(Boolean.parseBoolean(statusStr));
                }
                serveTypes.add(serveType);
            }
        }
        return serveTypes;
    }

    // Make Over Category
    public static List<MMakeOverCategory> excelToMakeOverCategories(InputStream is) throws IOException {
        List<MMakeOverCategory> categories = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MMakeOverCategory category = new MMakeOverCategory();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    category.setCategoryId(Long.parseLong(idStr));
                }
                category.setCategoryName(getCellValueAsString(row.getCell(1)));
                category.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    category.setStatus(Boolean.parseBoolean(statusStr));
                }
                categories.add(category);
            }
        }
        return categories;
    }

    public static List<MMakeOverPackage> excelToMakeOvers(InputStream is) throws IOException {
        List<MMakeOverPackage> makeOvers = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MMakeOverPackage makeOver = new MMakeOverPackage();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    makeOver.setPackageId(Long.parseLong(idStr));
                }
                String categoryIdStr = getCellValueAsString(row.getCell(1));
                if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                    makeOver.setCategoryId(Long.parseLong(categoryIdStr));
                }
                makeOver.setPackageName(getCellValueAsString(row.getCell(2)));
                makeOver.setNameInLocal(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    makeOver.setStatus(Boolean.parseBoolean(statusStr));
                }
                makeOvers.add(makeOver);
            }
        }
        return makeOvers;
    }

    // Boutique Wear Category
    public static List<MBoutiqueWearCategory> excelToBoutiqueWearCategories(InputStream is) throws IOException {
        List<MBoutiqueWearCategory> categories = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MBoutiqueWearCategory category = new MBoutiqueWearCategory();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    category.setCategoryId(Long.parseLong(idStr));
                }
                category.setCategoryName(getCellValueAsString(row.getCell(1)));
                category.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    category.setStatus(Boolean.parseBoolean(statusStr));
                }
                categories.add(category);
            }
        }
        return categories;
    }

    public static List<MBoutiqueWear> excelToBoutiqueWears(InputStream is) throws IOException {
        List<MBoutiqueWear> boutiqueWears = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MBoutiqueWear wear = new MBoutiqueWear();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    wear.setBoutiqueWearId(Long.parseLong(idStr));
                }
                String categoryIdStr = getCellValueAsString(row.getCell(1));
                if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                    wear.setCategoryId(Long.parseLong(categoryIdStr));
                }
                wear.setTypeOfWear(getCellValueAsString(row.getCell(2)));
                wear.setNameInLocal(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    wear.setStatus(Boolean.parseBoolean(statusStr));
                }
                boutiqueWears.add(wear);
            }
        }
        return boutiqueWears;
    }

    public static List<MBoutiqueWearBrand> excelToBoutiqueWearBrands(InputStream is) throws IOException {
        List<MBoutiqueWearBrand> brands = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MBoutiqueWearBrand brand = new MBoutiqueWearBrand();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    brand.setBoutiqueWearBrandId(Long.parseLong(idStr));
                }
                String categoryIdStr = getCellValueAsString(row.getCell(1));
                if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                    brand.setCategoryId(Long.parseLong(categoryIdStr));
                }
                brand.setBrandName(getCellValueAsString(row.getCell(2)));
                brand.setNameInLocal(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    brand.setStatus(Boolean.parseBoolean(statusStr));
                }
                brands.add(brand);
            }
        }
        return brands;
    }

    // Textile Wear Category
    public static List<MTextileWearCategory> excelToTextileWearCategories(InputStream is) throws IOException {
        List<MTextileWearCategory> categories = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MTextileWearCategory category = new MTextileWearCategory();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    category.setCategoryId(Long.parseLong(idStr));
                }
                category.setCategoryName(getCellValueAsString(row.getCell(1)));
                category.setNameInLocal(getCellValueAsString(row.getCell(2)));
                String statusStr = getCellValueAsString(row.getCell(3));
                if (statusStr != null && !statusStr.isEmpty()) {
                    category.setStatus(Boolean.parseBoolean(statusStr));
                }
                categories.add(category);
            }
        }
        return categories;
    }

    public static List<MTextileWear> excelToTextileWears(InputStream is) throws IOException {
        List<MTextileWear> textileWears = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MTextileWear wear = new MTextileWear();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    wear.setTextileWearId(Long.parseLong(idStr));
                }
                String categoryIdStr = getCellValueAsString(row.getCell(1));
                if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                    wear.setCategoryId(Long.parseLong(categoryIdStr));
                }
                wear.setTypeOfWear(getCellValueAsString(row.getCell(2)));
                wear.setNameInLocal(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    wear.setStatus(Boolean.parseBoolean(statusStr));
                }
                textileWears.add(wear);
            }
        }
        return textileWears;
    }

    public static List<MTextileWearBrand> excelToTextileWearBrands(InputStream is) throws IOException {
        List<MTextileWearBrand> brands = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row row = rows.next();
                if (rowNumber++ == 0) continue;
                if (isRowEmpty(row)) continue;

                MTextileWearBrand brand = new MTextileWearBrand();
                String idStr = getCellValueAsString(row.getCell(0));
                if (idStr != null && !idStr.isEmpty()) {
                    brand.setTextileWearBrandId(Long.parseLong(idStr));
                }
                String categoryIdStr = getCellValueAsString(row.getCell(1));
                if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                    brand.setCategoryId(Long.parseLong(categoryIdStr));
                }
                brand.setBrandName(getCellValueAsString(row.getCell(2)));
                brand.setNameInLocal(getCellValueAsString(row.getCell(3)));
                String statusStr = getCellValueAsString(row.getCell(4));
                if (statusStr != null && !statusStr.isEmpty()) {
                    brand.setStatus(Boolean.parseBoolean(statusStr));
                }
                brands.add(brand);
            }
        }
        return brands;
    }
}
