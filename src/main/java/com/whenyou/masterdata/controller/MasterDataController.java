package com.whenyou.masterdata.controller;

import com.whenyou.masterdata.dto.MDistrictDto;
import com.whenyou.masterdata.dto.MPincodeDto;
import com.whenyou.masterdata.dto.MVehicleDto;
import com.whenyou.masterdata.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {

    @Value("${login-service.url}")
    private String loginServiceUrl;

    @Value("${spring.security.jwt.prefix}")
    private String prefix;

    @Autowired MasterDataService masterDataService;

    // =========================================== Districts Controller =============================================================

    @GetMapping("/districts")
    public ResponseEntity<List<MDistrictDto>> getDistricts() {
        return ResponseEntity.ok(masterDataService.getActiveDistricts());
    }

    // =========================================== Pincodes Controller ===============================================================

    @GetMapping("/pincodes")
    public ResponseEntity<List<MPincodeDto>> getPincodes(@RequestParam Optional<String> pincode) {
        return ResponseEntity.ok(masterDataService.getActivePincodes(pincode));
    }

    // =========================================== Vehicle Controller =================================================

    @GetMapping("/vehicle-brands")
    public ResponseEntity<List<String>> getVehicleBrands() {
        return ResponseEntity.ok(masterDataService.getActiveVehicleBrands());
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<MVehicleDto>> getVehicles(@RequestParam Optional<String> brandName, @RequestParam Optional<String> modelType, @RequestParam Optional<String> modelName) {
        return ResponseEntity.ok(masterDataService.getActiveVehicles(brandName, modelType, modelName));
    }

}
