package in.com.whenyou.masterdata.controller;

import in.com.whenyou.masterdata.dto.*;
import in.com.whenyou.masterdata.dto.*;
import in.com.whenyou.masterdata.service.MasterDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "/APIs for Master data", description = "Apis for Master data.")
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

    // =========================================== Jewel Controller =================================================

    @GetMapping("/jewels")
    public ResponseEntity<List<MJewelDto>> getJewels() {
        return ResponseEntity.ok(masterDataService.getActiveJewels());
    }

    // =========================================== Jewel Material Controller =================================================

    @GetMapping("/jewel-materials")
    public ResponseEntity<List<String>> getJewelMaterials() {
        return ResponseEntity.ok(masterDataService.getActiveJewelMaterials());
    }

    @GetMapping("/jewel-purities/{material}")
    public ResponseEntity<List<MJewelMaterialDto>> getJewelPurities(@PathVariable String material) {
        return ResponseEntity.ok(masterDataService.getMaterialPurities(material));
    }

    //=========================================== Catering Serve Type Controller ======================================================

    @GetMapping("/catering-serve-types")
    public ResponseEntity<List<MServeTypeDto>> getActiveServeTypes() {
        return ResponseEntity.ok(masterDataService.getActiveServeTypes());
    }

    //=========================================== Make Over Controller ======================================================

    @GetMapping("/make-overs/{category}")
    public ResponseEntity<List<MMakeOverDto>> getActiveMakeOvers(@PathVariable String category) {
        return ResponseEntity.ok(masterDataService.getActiveMakeOvers(category));
    }

    //=========================================== Boutique Wear Controller ======================================================

    @GetMapping("/boutique-wears/{category}")
    public ResponseEntity<List<MBoutiqueWearDto>> getActiveBoutiqueWears(@PathVariable String category) {
        return ResponseEntity.ok(masterDataService.getActiveBoutiqueWears(category));
    }

    //=========================================== Boutique Wear Brand Controller ======================================================

    @GetMapping("/boutique-wear-brands/{category}/{attireType}")
    public ResponseEntity<List<MBoutiqueWearBrandDto>> getActiveBoutiqueWearBrands(@PathVariable String category, @PathVariable String attireType) {
        return ResponseEntity.ok(masterDataService.getActiveBoutiqueWearBrands(category, attireType));
    }

    //=========================================== Textile Wear Controller ======================================================

    @GetMapping("/textile-wears/{category}")
    public ResponseEntity<List<MTextileWearDto>> getActiveTextileWears(@PathVariable String category) {
        return ResponseEntity.ok(masterDataService.getActiveTextileWears(category));
    }

    //=========================================== Textile Wear Brand Controller ======================================================

    @GetMapping("/textile-wear-brands/{category}/{attireType}")
    public ResponseEntity<List<MTextileWearBrandDto>> getActiveTextileWearBrands(@PathVariable String category, @PathVariable String attireType) {
        return ResponseEntity.ok(masterDataService.getActiveTextileWearBrands(category, attireType));
    }
}
