package com.whenyou.masterdata.controller;

import com.whenyou.masterdata.dto.MDistrictDto;
import com.whenyou.masterdata.dto.MPincodeDto;
import com.whenyou.masterdata.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {

    @Value("${login-service.url}")
    private String loginServiceUrl;

    @Value("${spring.security.jwt.prefix}")
    private String prefix;

    @Autowired MasterDataService masterDataService;

    // =========================================== Master Data Controller =============================================================

    @GetMapping("/districts")
    public ResponseEntity<List<MDistrictDto>> getDistricts() {
        return ResponseEntity.ok(masterDataService.getDistricts());
    }

    @GetMapping("/pincodes")
    public ResponseEntity<List<MPincodeDto>> getPincodes() {
        return ResponseEntity.ok(masterDataService.getPincodes());
    }

}
