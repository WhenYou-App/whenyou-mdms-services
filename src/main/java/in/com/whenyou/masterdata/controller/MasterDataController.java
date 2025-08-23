package in.com.whenyou.masterdata.controller;

import in.com.whenyou.masterdata.dto.*;
import in.com.whenyou.masterdata.service.MasterDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "APIs for Master data", description = "Apis for Master data.")
@RequestMapping("/api/master")
public class MasterDataController {
    @Autowired MasterDataService masterDataService;

    // =========================================== Districts Controller =============================================================

    @GetMapping("/districts")
    public ResponseEntity<List<MDistrictDto>> getDistricts() {
        return ResponseEntity.ok(masterDataService.getActiveDistricts());
    }

    // =========================================== Pincodes Controller ===============================================================

    @GetMapping("/pincodes")
    public ResponseEntity<List<MPincodeDto>> getPincodes(@RequestParam Optional<Long> districtId, @RequestParam Optional<String> pincode) {
        return ResponseEntity.ok(masterDataService.getActivePincodes(districtId, pincode));
    }

    // =========================================== Vehicle Controller =================================================

    @GetMapping("/vehicle/brands")
    public ResponseEntity<List<MVehicleBrandDto>> getVehicleBrands() {
        return ResponseEntity.ok(masterDataService.getActiveVehicleBrands());
    }

    @GetMapping("/vehicle/model-types")
    public ResponseEntity<List<MVehicleModelTypeDto>> getVehicleModelTypes() {
        return ResponseEntity.ok(masterDataService.getActiveVehicleModelTypes());
    }

    @GetMapping("/vehicle/model-names")
    public ResponseEntity<List<MVehicleModelNameDto>> getVehicleModelNames(@RequestParam Optional<Long> brandId, @RequestParam Optional<Long> modelTypeId) {
        return ResponseEntity.ok(masterDataService.getActiveVehicleModelNames(brandId, modelTypeId));
    }

    // =========================================== Jewel Controller =================================================

    @GetMapping("/jewels")
    public ResponseEntity<List<MJewelProductTypeDto>> getJewels() {
        return ResponseEntity.ok(masterDataService.getActiveJewels());
    }

    @GetMapping("/jewel/materials")
    public ResponseEntity<List<MJewelMaterialDto>> getJewelMaterials() {
        return ResponseEntity.ok(masterDataService.getActiveJewelMaterials());
    }

    @GetMapping("/jewel/material/purities/{materialId}")
    public ResponseEntity<List<MJewelMaterialPurityDto>> getJewelPurities(@PathVariable Long materialId) {
        return ResponseEntity.ok(masterDataService.getActiveJewelMaterialPurities(materialId));
    }

    //=========================================== Catering Serve Type Controller ======================================================

    @GetMapping("/catering/serve-types")
    public ResponseEntity<List<MServeTypeDto>> getActiveServeTypes() {
        return ResponseEntity.ok(masterDataService.getActiveServeTypes());
    }

    //=========================================== Make Over Controller ======================================================

    @GetMapping("/make-over/categories")
    public ResponseEntity<List<MMakeOverCategoryDto>> getActiveMakeOverCategories() {
        return ResponseEntity.ok(masterDataService.getActiveMakeOverCategories());
    }

    @GetMapping("/make-overs/{categoryId}")
    public ResponseEntity<List<MMakeOverPackageDto>> getActiveMakeOvers(@PathVariable Long categoryId) {
        return ResponseEntity.ok(masterDataService.getActiveMakeOvers(categoryId));
    }

    //=========================================== Boutique Wear Controller ======================================================

    @GetMapping("/boutique-wear-categories")
    public ResponseEntity<List<MBoutiqueWearCategoryDto>> getActiveBoutiqueWearCategories() {
        return ResponseEntity.ok(masterDataService.getActiveBoutiqueWearCategories());
    }

    @GetMapping("/boutique-wears/{categoryId}")
    public ResponseEntity<List<MBoutiqueWearDto>> getActiveBoutiqueWears(@PathVariable Long categoryId) {
        return ResponseEntity.ok(masterDataService.getActiveBoutiqueWears(categoryId));
    }

    @GetMapping("/boutique-wear-brands/{categoryId}")
    public ResponseEntity<List<MBoutiqueWearBrandDto>> getActiveBoutiqueWearBrands(@PathVariable Long categoryId) {
        return ResponseEntity.ok(masterDataService.getActiveBoutiqueWearBrands(categoryId));
    }

    //=========================================== Textile Wear Controller ======================================================

    @GetMapping("/textile-wear-categories")
    public ResponseEntity<List<MTextileWearCategoryDto>> getActiveTextileWearCategories() {
        return ResponseEntity.ok(masterDataService.getActiveTextileWearCategories());
    }

    @GetMapping("/textile-wears/{categoryId}")
    public ResponseEntity<List<MTextileWearDto>> getActiveTextileWears(@PathVariable Long categoryId) {
        return ResponseEntity.ok(masterDataService.getActiveTextileWears(categoryId));
    }

    @GetMapping("/textile-wear-brands/{categoryId}")
    public ResponseEntity<List<MTextileWearBrandDto>> getActiveTextileWearBrands(@PathVariable Long categoryId) {
        return ResponseEntity.ok(masterDataService.getActiveTextileWearBrands(categoryId));
    }
}
