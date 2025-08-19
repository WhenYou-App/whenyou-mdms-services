package com.whenyou.masterdata.service;

import com.whenyou.masterdata.entity.*;
import com.whenyou.masterdata.excelutil.ExcelUtility;
import com.whenyou.masterdata.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InitService {
    @Autowired MJewelRepository jewelsRepository;
    @Autowired MPincodeRepository pincodeRepository;
    @Autowired MVehicleRepository vehicleRepository;
    @Autowired MMakeOverRepository makeOverRepository;
    @Autowired MDistrictRepository districtRepository;
    @Autowired MServeTypeRepository serveTypeRepository;
    @Autowired MBoutiqueWearRepository boutiqueWearRepository;
    @Autowired MJewelMaterialRepository jewelMaterialRepository;
    @Autowired MBoutiqueWearBrandRepository boutiqueWearBrandRepository;

    @Transactional
    public void initData(MultipartFile districtsFile, MultipartFile pincodesFile, MultipartFile vehiclesFile,
                         MultipartFile jewelsFile, MultipartFile jewelMaterialsFile, MultipartFile serveTypesFile, MultipartFile makeOversFile,
                         MultipartFile boutiqueWearsFile, MultipartFile boutiqueWearBrandsFile) throws IOException {
        // Process Districts if file is present and not empty
        if (districtsFile != null && !districtsFile.isEmpty()) {
            List<MDistrict> districts = ExcelUtility.excelToDistricts(districtsFile.getInputStream());
            for (MDistrict district : districts) {
                districtRepository.findByExcelId(district.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setName(district.getName());
                            existing.setNameInLocal(district.getNameInLocal());
                            existing.setStatus(district.isStatus());
                            districtRepository.save(existing);
                        }, () -> {
                            // New district entry
                            district.setId(null); // Let UUID be auto-generated
                            districtRepository.save(district);
                        });
            }
        }

        // Process Pincodes if file is present and not empty
        if (pincodesFile != null && !pincodesFile.isEmpty()) {
            List<MPincode> pincodes = ExcelUtility.excelToPincodes(pincodesFile.getInputStream());
            for (MPincode pincode : pincodes) {
                pincodeRepository.findByExcelId(pincode.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setName(pincode.getName());
                            existing.setNameInLocal(pincode.getNameInLocal());
                            existing.setPincode(pincode.getPincode());
                            existing.setStatus(pincode.isStatus());
                            pincodeRepository.save(existing);
                        }, () -> {
                            // New pincode entry
                            pincode.setId(null); // Let UUID be auto-generated
                            pincodeRepository.save(pincode);
                        });
            }
        }

        // Process Vehicle if file is present and not empty
        if (vehiclesFile != null && !vehiclesFile.isEmpty()) {
            List<MVehicle> vehicles = ExcelUtility.excelToVehicles(vehiclesFile.getInputStream());
            for (MVehicle vehicle : vehicles) {
                vehicleRepository.findByExcelId(vehicle.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setBrandName(vehicle.getBrandName());
                            existing.setModelName(vehicle.getModelName());
                            existing.setModelType(vehicle.getModelType());
                            existing.setStatus(vehicle.isStatus());
                            vehicleRepository.save(existing);
                        }, () -> {
                            // New pincode entry
                            vehicle.setId(null); // Let UUID be auto-generated
                            vehicleRepository.save(vehicle);
                        });
            }
        }

        // Process Jewels
        if (jewelsFile != null && !jewelsFile.isEmpty()) {
            List<MJewel> jewels = ExcelUtility.excelToJewels(jewelsFile.getInputStream());
            for (MJewel jewel : jewels) {
                jewelsRepository.findByExcelId(jewel.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setProductType(jewel.getProductType());
                            existing.setStatus(jewel.isStatus());
                            jewelsRepository.save(existing);
                        }, () -> {
                            jewel.setId(null);
                            jewelsRepository.save(jewel);
                        });
            }
        }

        // Process Jewel Materials
        if (jewelMaterialsFile != null && !jewelMaterialsFile.isEmpty()) {
            List<MJewelMaterial> jewelMaterials = ExcelUtility.excelToJewelMaterials(jewelMaterialsFile.getInputStream());
            for (MJewelMaterial jewelMaterial : jewelMaterials) {
                jewelMaterialRepository.findByExcelId(jewelMaterial.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setMaterial(jewelMaterial.getMaterial());
                            existing.setPurity(jewelMaterial.getPurity());
                            existing.setStatus(jewelMaterial.isStatus());
                            jewelMaterialRepository.save(existing);
                        }, () -> {
                            jewelMaterial.setId(null);
                            jewelMaterialRepository.save(jewelMaterial);
                        });
            }
        }

        // Process Serve Types
        if (serveTypesFile != null && !serveTypesFile.isEmpty()) {
            List<MServeType> serveTypes = ExcelUtility.excelToServeTypes(serveTypesFile.getInputStream());
            for (MServeType serveType : serveTypes) {
                serveTypeRepository.findByExcelId(serveType.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setServeType(serveType.getServeType());
                            existing.setStatus(serveType.isStatus());
                            serveTypeRepository.save(existing);
                        }, () -> {
                            serveType.setId(null);
                            serveTypeRepository.save(serveType);
                        });
            }
        }

        // Process Make Overs
        if (makeOversFile != null && !makeOversFile.isEmpty()) {
            List<MMakeOver> makeOvers = ExcelUtility.excelToMakeOvers(makeOversFile.getInputStream());
            for (MMakeOver makeOver : makeOvers) {
                makeOverRepository.findByExcelId(makeOver.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setPackageName(makeOver.getPackageName());
                            existing.setCategory(makeOver.getCategory());
                            existing.setStatus(makeOver.isStatus());
                            makeOverRepository.save(existing);
                        }, () -> {
                            makeOver.setId(null);
                            makeOverRepository.save(makeOver);
                        });
            }
        }

        // Process Boutique Wears
        if (boutiqueWearsFile != null && !boutiqueWearsFile.isEmpty()) {
            List<MBoutiqueWear> boutiqueWears = ExcelUtility.excelToBoutiqueWears(boutiqueWearsFile.getInputStream());
            for (MBoutiqueWear boutiqueWear : boutiqueWears) {
                boutiqueWearRepository.findByExcelId(boutiqueWear.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setTypeOfWear(boutiqueWear.getTypeOfWear());
                            existing.setCategory(boutiqueWear.getCategory());
                            existing.setAttireType(boutiqueWear.getAttireType());
                            existing.setStatus(boutiqueWear.isStatus());
                            boutiqueWearRepository.save(existing);
                        }, () -> {
                            boutiqueWear.setId(null);
                            boutiqueWearRepository.save(boutiqueWear);
                        });
            }
        }

        // Process Boutique Wear Brands
        if (boutiqueWearBrandsFile != null && !boutiqueWearBrandsFile.isEmpty()) {
            List<MBoutiqueWearBrand> brands = ExcelUtility.excelToBoutiqueWearBrands(boutiqueWearBrandsFile.getInputStream());
            for (MBoutiqueWearBrand brand : brands) {
                boutiqueWearBrandRepository.findByExcelId(brand.getExcelId())
                        .ifPresentOrElse(existing -> {
                            existing.setBrandName(brand.getBrandName());
                            existing.setCategory(brand.getCategory());
                            existing.setAttireType(brand.getAttireType());
                            existing.setStatus(brand.isStatus());
                            boutiqueWearBrandRepository.save(existing);
                        }, () -> {
                            brand.setId(null);
                            boutiqueWearBrandRepository.save(brand);
                        });
            }
        }
    }
}
