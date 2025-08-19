package in.com.whenyou.masterdata.controller;

import in.com.whenyou.masterdata.model.Message;
import in.com.whenyou.masterdata.service.InitService;
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
    public ResponseEntity<Message> initData(@RequestParam(value = "districtsFile", required = false) MultipartFile districtsFile,
                                            @RequestParam(value = "pincodesFile", required = false) MultipartFile pincodesFile,
                                            @RequestParam(value = "vehiclesFile", required = false) MultipartFile vehiclesFile,
                                            @RequestParam(value = "jewelsFile", required = false) MultipartFile jewelsFile,
                                            @RequestParam(value = "jewelMaterialsFile", required = false) MultipartFile jewelMaterialsFile,
                                            @RequestParam(value = "serveTypesFile", required = false) MultipartFile serveTypesFile,
                                            @RequestParam(value = "makeOversFile", required = false) MultipartFile makeOversFile,
                                            @RequestParam(value = "boutiqueWearsFile", required = false) MultipartFile boutiqueWearsFile,
                                            @RequestParam(value = "boutiqueWearBrandsFile", required = false) MultipartFile boutiqueWearBrandsFile,
                                            @RequestParam(value = "textileWearsFile", required = false) MultipartFile textileWearsFile,
                                            @RequestParam(value = "textileWearBrandsFile", required = false) MultipartFile textileWearBrandsFile) {
        try {
            initService.initData(districtsFile, pincodesFile, vehiclesFile, jewelsFile, jewelMaterialsFile, serveTypesFile, makeOversFile, boutiqueWearsFile, boutiqueWearBrandsFile, textileWearsFile, textileWearBrandsFile);
            return ResponseEntity.ok(Message.builder().status(true).message("Initialization completed successfully!").build());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Message.builder().status(false).message("Error processing files: " + e.getMessage()).build());
        }
    }
}
