package com.whenyou.masterdata.controller;

import com.whenyou.masterdata.config.JwtUtil;
import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {

    @Value("${login-service.url}")
    private String loginServiceUrl;

    @Value("${spring.security.jwt.prefix}")
    private String prefix;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MasterDataService masterDataService;

    private boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    @GetMapping("/data")
    public ResponseEntity<List<MDistrict>> getData() {
        List<MDistrict> mDistricts = masterDataService.getMDistricts();
        return ResponseEntity.ok(mDistricts);
    }

}
