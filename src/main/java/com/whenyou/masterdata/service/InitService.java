package com.whenyou.masterdata.service;

import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.entity.MPincode;
import com.whenyou.masterdata.entity.MVehicle;
import com.whenyou.masterdata.excelutil.ExcelUtility;
import com.whenyou.masterdata.repository.MDistrictRepository;
import com.whenyou.masterdata.repository.MPincodeRepository;
import com.whenyou.masterdata.repository.MVehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InitService {
    @Autowired MDistrictRepository districtRepository;
    @Autowired MPincodeRepository pincodeRepository;
    @Autowired MVehicleRepository vehicleRepository;

    @Transactional
    public void initData(MultipartFile districtsFile, MultipartFile pincodesFile, MultipartFile vehiclesFile) throws IOException {
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
    }
}
