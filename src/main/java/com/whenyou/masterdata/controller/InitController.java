package com.whenyou.masterdata.controller;

import com.whenyou.masterdata.model.Message;
import com.whenyou.masterdata.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/init")
public class InitController {
    @Autowired InitService initService;

    @PostMapping("/data")
    public ResponseEntity<Message> initData(@RequestParam(value = "districtsFile", required = false) MultipartFile districtsFile, @RequestParam(value = "pincodesFile", required = false) MultipartFile pincodesFile, @RequestParam(value = "carsFile", required = false) MultipartFile carsFile) {
        try {
            initService.initData(districtsFile, pincodesFile, carsFile);
            return ResponseEntity.ok(Message.builder().status(true).message("Initialization completed successfully!").build());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Message.builder().status(false).message("Error processing files: " + e.getMessage()).build());
        }
    }
}
