package com.whenyou.masterdata.service;

import com.whenyou.masterdata.dto.*;
import com.whenyou.masterdata.entity.*;
import com.whenyou.masterdata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MasterDataService {
    @Autowired MJewelRepository jewelsRepository;
    @Autowired MPincodeRepository mPincodeRepository;
    @Autowired MVehicleRepository mVehicleRepository;
    @Autowired MMakeOverRepository makeOverRepository;
    @Autowired MDistrictRepository mDistrictRepository;
    @Autowired MServeTypeRepository serveTypeRepository;
    @Autowired MTextileWearRepository textileWearRepository;
    @Autowired MBoutiqueWearRepository boutiqueWearRepository;
    @Autowired MJewelMaterialRepository jewelMaterialRepository;
    @Autowired MTextileWearBrandRepository textileWearBrandRepository;
    @Autowired MBoutiqueWearBrandRepository boutiqueWearBrandRepository;

    //=========================================== District Service ======================================================

    public List<MDistrictDto> getActiveDistricts() {
        return mDistrictRepository.findByStatus(true).stream().map(fromDistrict()).collect(Collectors.toList());
    }

    //=========================================== Pincode Service ======================================================

    public List<MPincodeDto> getActivePincodes(Optional<String> pincode) {
        if (pincode.isPresent()) {
            return mPincodeRepository.findByStatusAndPincode(true, pincode.get()).stream().map(fromMPincode()).collect(Collectors.toList());
        }else {
            return mPincodeRepository.findByStatus(true).stream().map(fromMPincode()).collect(Collectors.toList());
        }
    }

    //=========================================== Vehicle Service ======================================================

    public List<String> getActiveVehicleBrands() {
        return mVehicleRepository.findByStatus(true).stream()
                .map(vehicle -> fromVehicle().apply(vehicle).getBrandName()).distinct().collect(Collectors.toList());
    }

    public List<MVehicleDto> getActiveVehicles(Optional<String> brandName, Optional<String> modelType, Optional<String> modelName) {
        if (brandName.isPresent() && modelType.isPresent() && modelName.isPresent()) {
            return mVehicleRepository.findByStatusAndBrandNameIgnoreCaseAndModelTypeIgnoreCaseAndModelNameIgnoreCase(true, brandName.get(), modelType.get(), modelName.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (brandName.isPresent() && modelType.isPresent()) {
            return mVehicleRepository.findByStatusAndBrandNameIgnoreCaseAndModelTypeIgnoreCase(true, brandName.get(), modelType.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (brandName.isPresent() && modelName.isPresent()) {
            return mVehicleRepository.findByStatusAndBrandNameIgnoreCaseAndModelNameIgnoreCase(true, brandName.get(), modelName.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (modelType.isPresent() && modelName.isPresent()) {
            return mVehicleRepository.findByStatusAndModelTypeIgnoreCaseAndModelNameIgnoreCase(true, modelType.get(), modelName.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (modelType.isPresent()) {
            return mVehicleRepository.findByStatusAndModelTypeIgnoreCase(true, modelType.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (modelName.isPresent()) {
            return mVehicleRepository.findByStatusAndModelNameIgnoreCase(true, modelName.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else if (brandName.isPresent()) {
            return mVehicleRepository.findByStatusAndBrandNameIgnoreCase(true, brandName.get()).stream().map(fromVehicle()).collect(Collectors.toList());
        } else {
            return mVehicleRepository.findByStatus(true).stream().map(fromVehicle()).collect(Collectors.toList());
        }
    }

    //=========================================== Jewel Service ======================================================

    public List<MJewelDto> getActiveJewels() {
        return jewelsRepository.findByStatus(true).stream().map(fromJewel()).collect(Collectors.toList());
    }

    //============================================ Jewel Material Service ======================================================

    public List<String> getActiveJewelMaterials() {
        return jewelMaterialRepository.findByStatus(true).stream()
                .map(jewelMaterial -> fromJewelMaterial().apply(jewelMaterial).getMaterial()).distinct().collect(Collectors.toList());
    }

    public List<MJewelMaterialDto> getMaterialPurities(String material) {
        return jewelMaterialRepository.findByStatus(true).stream().map(fromJewelMaterial()).collect(Collectors.toList());
    }

    //=========================================== Catering Serve Type Service ======================================================

    public List<MServeTypeDto> getActiveServeTypes() {
        return serveTypeRepository.findByStatus(true).stream().map(fromServeType()).collect(Collectors.toList());
    }

    //=========================================== Make Over Service ======================================================

    public List<MMakeOverDto> getActiveMakeOvers(String category) {
        return makeOverRepository.findByStatusAndCategoryIgnoreCase(true, category).stream().map(fromMakeOver()).collect(Collectors.toList());
    }

    //=========================================== Boutique Wear Service ======================================================

    public List<MBoutiqueWearDto> getActiveBoutiqueWears(String category) {
        return boutiqueWearRepository.findByStatusAndCategoryIgnoreCase(true, category).stream().map(fromBoutiqueWear()).collect(Collectors.toList());
    }

    //=========================================== Boutique Wear Brand Service ======================================================

    public List<MBoutiqueWearBrandDto> getActiveBoutiqueWearBrands(String category, String attireType) {
        return boutiqueWearBrandRepository.findByStatusAndCategoryIgnoreCaseAndAttireTypeIgnoreCase(true, category, attireType).stream().map(fromBoutiqueWearBrand()).collect(Collectors.toList());
    }

    //=========================================== Textile Wear Service ======================================================

    public List<MTextileWearDto> getActiveTextileWears(String category) {
        return textileWearRepository.findByStatusAndCategoryIgnoreCase(true, category).stream().map(fromTextileWear()).collect(Collectors.toList());
    }

    //=========================================== Textile Wear Brand Service ======================================================

    public List<MTextileWearBrandDto> getActiveTextileWearBrands(String category, String attireType) {
        return textileWearBrandRepository.findByStatusAndCategoryIgnoreCaseAndAttireTypeIgnoreCase(true, category, attireType).stream().map(fromTextileWearBrand()).collect(Collectors.toList());
    }

    //=========================================== District Converter Function ======================================================

    public Function<MDistrict, MDistrictDto> fromDistrict() {
        return new Function<MDistrict, MDistrictDto>() {
            @Override
            public MDistrictDto apply(MDistrict mDistrict) {
                return MDistrictDto.builder()
                        .id(mDistrict.getId())
                        .excelId(mDistrict.getExcelId())
                        .name(mDistrict.getName())
                        .nameInLocal(mDistrict.getNameInLocal())
                        .status(mDistrict.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Pincode Converter Function ======================================================

    public Function<MPincode, MPincodeDto> fromMPincode() {
        return new Function<MPincode, MPincodeDto>() {
            @Override
            public MPincodeDto apply(MPincode mPincode) {
                return MPincodeDto.builder()
                        .id(mPincode.getId())
                        .excelId(mPincode.getExcelId())
                        .name(mPincode.getName())
                        .nameInLocal(mPincode.getNameInLocal())
                        .pincode(mPincode.getPincode())
                        .status(mPincode.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Vehicle Converter Function ======================================================

    public Function<MVehicle, MVehicleDto> fromVehicle() {
        return new Function<MVehicle, MVehicleDto>() {
            @Override
            public MVehicleDto apply(MVehicle mVehicle) {
                return MVehicleDto.builder()
                        .id(mVehicle.getId())
                        .excelId(mVehicle.getExcelId())
                        .brandName(mVehicle.getBrandName())
                        .modelType(mVehicle.getModelType())
                        .modelName(mVehicle.getModelName())
                        .status(mVehicle.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Jewel Converter Function ======================================================

    public Function<MJewel, MJewelDto> fromJewel() {
        return new Function<MJewel, MJewelDto>() {
            @Override
            public MJewelDto apply(MJewel mJewel) {
                return MJewelDto.builder()
                        .id(mJewel.getId())
                        .excelId(mJewel.getExcelId())
                        .productType(mJewel.getProductType())
                        .status(mJewel.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Jewel Material Converter Function ======================================================

    public Function<MJewelMaterial, MJewelMaterialDto> fromJewelMaterial() {
        return new Function<MJewelMaterial, MJewelMaterialDto>() {
            @Override
            public MJewelMaterialDto apply(MJewelMaterial mJewelMaterial) {
                return MJewelMaterialDto.builder()
                        .id(mJewelMaterial.getId())
                        .excelId(mJewelMaterial.getExcelId())
                        .material(mJewelMaterial.getMaterial())
                        .purity(mJewelMaterial.getPurity())
                        .status(mJewelMaterial.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Catering Serve Type Converter Function ======================================================

    public Function<MServeType, MServeTypeDto> fromServeType() {
        return new Function<MServeType, MServeTypeDto>() {
            @Override
            public MServeTypeDto apply(MServeType mServeType) {
                return MServeTypeDto.builder()
                        .id(mServeType.getId())
                        .excelId(mServeType.getExcelId())
                        .serveType(mServeType.getServeType())
                        .status(mServeType.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Make Over Service Converter Function ======================================================

    public Function<MMakeOver, MMakeOverDto> fromMakeOver() {
        return new Function<MMakeOver, MMakeOverDto>() {
            @Override
            public MMakeOverDto apply(MMakeOver mMakeOver) {
                return MMakeOverDto.builder()
                        .id(mMakeOver.getId())
                        .excelId(mMakeOver.getExcelId())
                        .packageName(mMakeOver.getPackageName())
                        .category(mMakeOver.getCategory())
                        .status(mMakeOver.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Boutique Wear Converter Function ======================================================

    public Function<MBoutiqueWear, MBoutiqueWearDto> fromBoutiqueWear() {
        return new Function<MBoutiqueWear, MBoutiqueWearDto>() {
            @Override
            public MBoutiqueWearDto apply(MBoutiqueWear mBoutiqueWear) {
                return MBoutiqueWearDto.builder()
                        .id(mBoutiqueWear.getId())
                        .excelId(mBoutiqueWear.getExcelId())
                        .typeOfWear(mBoutiqueWear.getTypeOfWear())
                        .category(mBoutiqueWear.getCategory())
                        .attireType(mBoutiqueWear.getAttireType())
                        .status(mBoutiqueWear.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Boutique Wear Brand Converter Function ======================================================

    public Function<MBoutiqueWearBrand, MBoutiqueWearBrandDto> fromBoutiqueWearBrand() {
        return new Function<MBoutiqueWearBrand, MBoutiqueWearBrandDto>() {
            @Override
            public MBoutiqueWearBrandDto apply(MBoutiqueWearBrand mBoutiqueWearBrand) {
                return MBoutiqueWearBrandDto.builder()
                        .id(mBoutiqueWearBrand.getId())
                        .excelId(mBoutiqueWearBrand.getExcelId())
                        .brandName(mBoutiqueWearBrand.getBrandName())
                        .category(mBoutiqueWearBrand.getCategory())
                        .attireType(mBoutiqueWearBrand.getAttireType())
                        .status(mBoutiqueWearBrand.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Textile Wear Converter Function ======================================================

    public Function<MTextileWear, MTextileWearDto> fromTextileWear() {
        return new Function<MTextileWear, MTextileWearDto>() {
            @Override
            public MTextileWearDto apply(MTextileWear mTextileWear) {
                return MTextileWearDto.builder()
                        .id(mTextileWear.getId())
                        .excelId(mTextileWear.getExcelId())
                        .typeOfWear(mTextileWear.getTypeOfWear())
                        .category(mTextileWear.getCategory())
                        .attireType(mTextileWear.getAttireType())
                        .status(mTextileWear.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Textile Wear Brand Converter Function ======================================================

    public Function<MTextileWearBrand, MTextileWearBrandDto> fromTextileWearBrand() {
        return new Function<MTextileWearBrand, MTextileWearBrandDto>() {
            @Override
            public MTextileWearBrandDto apply(MTextileWearBrand mTextileWearBrand) {
                return MTextileWearBrandDto.builder()
                        .id(mTextileWearBrand.getId())
                        .excelId(mTextileWearBrand.getExcelId())
                        .brandName(mTextileWearBrand.getBrandName())
                        .category(mTextileWearBrand.getCategory())
                        .attireType(mTextileWearBrand.getAttireType())
                        .status(mTextileWearBrand.isStatus())
                        .build();
            }
        };
    }
}
