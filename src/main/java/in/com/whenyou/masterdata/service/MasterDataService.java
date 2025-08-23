package in.com.whenyou.masterdata.service;

import in.com.whenyou.masterdata.dto.*;
import in.com.whenyou.masterdata.entity.*;
import in.com.whenyou.masterdata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MasterDataService {
    @Autowired MPincodeRepository mPincodeRepository;
    @Autowired MDistrictRepository mDistrictRepository;
    @Autowired MServeTypeRepository mServeTypeRepository;
    @Autowired MTextileWearRepository mTextileWearRepository;
    @Autowired MMakeOverPackageRepository mMakeOverRepository;
    @Autowired MBoutiqueWearRepository mBoutiqueWearRepository;
    @Autowired MVehicleBrandRepository mVehicleBrandRepository;
    @Autowired MJewelMaterialRepository mJewelMaterialRepository;
    @Autowired MTextileWearBrandRepository mTextileWearBrandRepository;
    @Autowired MJewelProductTypeRepository mJewelProductTypeRepository;
    @Autowired MMakeOverCategoryRepository mMakeOverCategoryRepository;
    @Autowired MVehicleModelTypeRepository mVehicleModelTypeRepository;
    @Autowired MVehicleModelNameRepository mVehicleModelNameRepository;
    @Autowired MBoutiqueWearBrandRepository mBoutiqueWearBrandRepository;
    @Autowired MBoutiqueWearCategoryRepository mBoutiqueWearCategoryRepository;
    @Autowired MJewelMaterialPurityRepository mJewelMaterialPurityRepository;
    @Autowired MTextileWearCategoryRepository mTextileWearCategoryRepository;

    //=========================================== District Service ======================================================

    public List<MDistrictDto> getActiveDistricts() {
        return mDistrictRepository.findByStatus(true).stream().map(fromDistrict()).collect(Collectors.toList());
    }

    //=========================================== Pincode Service ======================================================

    public List<MPincodeDto> getActivePincodes(Optional<Long> districtId, Optional<String> pincode) {
        if (districtId.isPresent() && pincode.isPresent()) {
            return mPincodeRepository.findByStatusAndDistrictIdAndPincode(true, districtId.get(), pincode.get()).stream().map(fromMPincode()).collect(Collectors.toList());
        } else if (districtId.isPresent()) {
            return mPincodeRepository.findByStatusAndDistrictId(true, districtId.get()).stream().map(fromMPincode()).collect(Collectors.toList());
        } else if (pincode.isPresent()) {
                return mPincodeRepository.findByStatusAndPincode(true, pincode.get()).stream().map(fromMPincode()).collect(Collectors.toList());
        } else {
            return mPincodeRepository.findByStatus(true).stream().map(fromMPincode()).collect(Collectors.toList());
        }
    }

    //=========================================== Vehicle Service ======================================================

    public List<MVehicleBrandDto> getActiveVehicleBrands() {
        return mVehicleBrandRepository.findByStatus(true).stream().map(fromVehicleBrand()).collect(Collectors.toList());
    }

    public List<MVehicleModelTypeDto> getActiveVehicleModelTypes() {
        return mVehicleModelTypeRepository.findByStatus(true).stream().map(fromVehicleModelType()).collect(Collectors.toList());
    }

    public List<MVehicleModelNameDto> getActiveVehicleModelNames(Optional<Long> brandId, Optional<Long> modelTypeId) {
        if (brandId.isPresent() && modelTypeId.isPresent()) {
            return mVehicleModelNameRepository.findByStatusAndBrandIdAndModelTypeId(true, brandId.get(), modelTypeId.get()).stream().map(fromVehicleModelName()).collect(Collectors.toList());
        } else if (brandId.isPresent()) {
            return mVehicleModelNameRepository.findByStatusAndBrandId(true, brandId.get()).stream().map(fromVehicleModelName()).collect(Collectors.toList());
        } else if (modelTypeId.isPresent()) {
            return mVehicleModelNameRepository.findByStatusAndModelTypeId(true, modelTypeId.get()).stream().map(fromVehicleModelName()).collect(Collectors.toList());
        } else {
            return mVehicleModelNameRepository.findByStatus(true).stream().map(fromVehicleModelName()).collect(Collectors.toList());
        }
    }

    //=========================================== Jewel Service ======================================================

    public List<MJewelProductTypeDto> getActiveJewels() {
        return mJewelProductTypeRepository.findByStatus(true).stream().map(fromJewelProductType()).collect(Collectors.toList());
    }

    public List<MJewelMaterialDto> getActiveJewelMaterials() {
       return mJewelMaterialRepository.findByStatus(true).stream().map(fromJewelMaterial()).collect(Collectors.toList());
    }

    public List<MJewelMaterialPurityDto> getActiveJewelMaterialPurities(Long materialId) {
        return mJewelMaterialPurityRepository.findByStatusAndJewelMaterialId(true, materialId).stream().map(fromJewelMaterialPurity()).collect(Collectors.toList());
    }

    //=========================================== Catering Serve Type Service ======================================================

    public List<MServeTypeDto> getActiveServeTypes() {
        return mServeTypeRepository.findByStatus(true).stream().map(fromServeType()).collect(Collectors.toList());
    }

    //=========================================== Make Over Service ======================================================

    public List<MMakeOverCategoryDto> getActiveMakeOverCategories() {
        return mMakeOverCategoryRepository.findByStatus(true).stream().map(fromMakeOverCategory()).collect(Collectors.toList());
    }

    public List<MMakeOverPackageDto> getActiveMakeOvers(Long categoryId) {
        return mMakeOverRepository.findByStatusAndCategoryId(true, categoryId).stream().map(fromMakeOver()).collect(Collectors.toList());
    }

    //=========================================== Boutique Wear Service ======================================================

    public List<MBoutiqueWearCategoryDto> getActiveBoutiqueWearCategories() {
        return mBoutiqueWearCategoryRepository.findByStatus(true).stream().map(fromBoutiqueWearCategory()).collect(Collectors.toList());
    }

    public List<MBoutiqueWearDto> getActiveBoutiqueWears(Long categoryId) {
        return mBoutiqueWearRepository.findByStatusAndCategoryId(true, categoryId).stream().map(fromBoutiqueWear()).collect(Collectors.toList());
    }

    public List<MBoutiqueWearBrandDto> getActiveBoutiqueWearBrands(Long categoryId) {
        return mBoutiqueWearBrandRepository.findByStatusAndCategoryId(true, categoryId).stream().map(fromBoutiqueWearBrand()).collect(Collectors.toList());
    }

    //=========================================== Textile Wear Service ======================================================

    public List<MTextileWearCategoryDto> getActiveTextileWearCategories() {
        return mTextileWearCategoryRepository.findByStatus(true).stream().map(fromTextileWearCategory()).collect(Collectors.toList());
    }

    public List<MTextileWearDto> getActiveTextileWears(Long categoryId) {
        return mTextileWearRepository.findByStatusAndCategoryId(true, categoryId).stream().map(fromTextileWear()).collect(Collectors.toList());
    }

    public List<MTextileWearBrandDto> getActiveTextileWearBrands(Long categoryId) {
        return mTextileWearBrandRepository.findByStatusAndCategoryId(true, categoryId).stream().map(fromTextileWearBrand()).collect(Collectors.toList());
    }

    //=========================================== District Converter Function ======================================================

    public Function<MDistrict, MDistrictDto> fromDistrict() {
        return new Function<MDistrict, MDistrictDto>() {
            @Override
            public MDistrictDto apply(MDistrict mDistrict) {
                return MDistrictDto.builder()
                        .id(mDistrict.getId())
                        .districtId(mDistrict.getDistrictId())
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
                        .pincodeId(mPincode.getPincodeId())
                        .districtId(mPincode.getDistrictId())
                        .name(mPincode.getName())
                        .nameInLocal(mPincode.getNameInLocal())
                        .pincode(mPincode.getPincode())
                        .status(mPincode.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Vehicle Converter Function ======================================================

    public Function<MVehicleBrand, MVehicleBrandDto> fromVehicleBrand() {
        return new Function<MVehicleBrand, MVehicleBrandDto>() {
            @Override
            public MVehicleBrandDto apply(MVehicleBrand mVehicleBrand) {
                return MVehicleBrandDto.builder()
                        .id(mVehicleBrand.getId())
                        .brandId(mVehicleBrand.getBrandId())
                        .brandName(mVehicleBrand.getBrandName())
                        .nameInLocal(mVehicleBrand.getNameInLocal())
                        .status(mVehicleBrand.isStatus())
                        .build();
            }
        };
    }

    public Function<MVehicleModelType, MVehicleModelTypeDto> fromVehicleModelType() {
        return new Function<MVehicleModelType, MVehicleModelTypeDto>() {
            @Override
            public MVehicleModelTypeDto apply(MVehicleModelType mVehicleModelType) {
                return MVehicleModelTypeDto.builder()
                        .id(mVehicleModelType.getId())
                        .modelTypeId(mVehicleModelType.getModelTypeId())
                        .modelTypeName(mVehicleModelType.getModelTypeName())
                        .status(mVehicleModelType.isStatus())
                        .build();
            }
        };
    }

    public Function<MVehicleModelName, MVehicleModelNameDto> fromVehicleModelName() {
        return new Function<MVehicleModelName, MVehicleModelNameDto>() {
            @Override
            public MVehicleModelNameDto apply(MVehicleModelName mVehicleModelName) {
                return MVehicleModelNameDto.builder()
                        .id(mVehicleModelName.getId())
                        .modelNameId(mVehicleModelName.getModelNameId())
                        .brandId(mVehicleModelName.getBrandId())
                        .modelTypeId(mVehicleModelName.getModelTypeId())
                        .modelName(mVehicleModelName.getModelName())
                        .nameInLocal(mVehicleModelName.getNameInLocal())
                        .status(mVehicleModelName.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Jewel Converter Function ======================================================

    public Function<MJewelProductType, MJewelProductTypeDto> fromJewelProductType() {
        return new Function<MJewelProductType, MJewelProductTypeDto>() {
            @Override
            public MJewelProductTypeDto apply(MJewelProductType mJewelProductType) {
                return MJewelProductTypeDto.builder()
                        .id(mJewelProductType.getId())
                        .jewelProductTypeId(mJewelProductType.getJewelProductTypeId())
                        .productTypeName(mJewelProductType.getProductTypeName())
                        .nameInLocal(mJewelProductType.getNameInLocal())
                        .status(mJewelProductType.isStatus())
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
                        .jewelMaterialId(mJewelMaterial.getJewelMaterialId())
                        .materialName(mJewelMaterial.getMaterialName())
                        .nameInLocal(mJewelMaterial.getNameInLocal())
                        .status(mJewelMaterial.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Jewel Material Purity Converter Function ======================================================

    public Function<MJewelMaterialPurity, MJewelMaterialPurityDto> fromJewelMaterialPurity() {
        return new Function<MJewelMaterialPurity, MJewelMaterialPurityDto>() {
            @Override
            public MJewelMaterialPurityDto apply(MJewelMaterialPurity mJewelMaterialPurity) {
                return MJewelMaterialPurityDto.builder()
                        .id(mJewelMaterialPurity.getId())
                        .jewelMaterialPurityId(mJewelMaterialPurity.getJewelMaterialPurityId())
                        .jewelMaterialId(mJewelMaterialPurity.getJewelMaterialId())
                        .materialPurity(mJewelMaterialPurity.getMaterialPurity())
                        .status(mJewelMaterialPurity.isStatus())
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
                        .serveTypeId(mServeType.getServeTypeId())
                        .serveType(mServeType.getServeType())
                        .nameInLocal(mServeType.getNameInLocal())
                        .status(mServeType.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Make Over Category Converter Function ======================================================

    public Function<MMakeOverCategory, MMakeOverCategoryDto> fromMakeOverCategory() {
        return new Function<MMakeOverCategory, MMakeOverCategoryDto>() {
            @Override
            public MMakeOverCategoryDto apply(MMakeOverCategory mMakeOverCategory) {
                return MMakeOverCategoryDto.builder()
                        .id(mMakeOverCategory.getId())
                        .categoryId(mMakeOverCategory.getCategoryId())
                        .categoryName(mMakeOverCategory.getCategoryName())
                        .nameInLocal(mMakeOverCategory.getNameInLocal())
                        .status(mMakeOverCategory.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Make Over Service Converter Function ======================================================

    public Function<MMakeOverPackage, MMakeOverPackageDto> fromMakeOver() {
        return new Function<MMakeOverPackage, MMakeOverPackageDto>() {
            @Override
            public MMakeOverPackageDto apply(MMakeOverPackage mMakeOverPackage) {
                return MMakeOverPackageDto.builder()
                        .id(mMakeOverPackage.getId())
                        .packageId(mMakeOverPackage.getPackageId())
                        .categoryId(mMakeOverPackage.getCategoryId())
                        .packageName(mMakeOverPackage.getPackageName())
                        .nameInLocal(mMakeOverPackage.getNameInLocal())
                        .status(mMakeOverPackage.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Boutique Wear Category Converter Function ======================================================

    public Function<MBoutiqueWearCategory, MBoutiqueWearCategoryDto> fromBoutiqueWearCategory() {
        return new Function<MBoutiqueWearCategory, MBoutiqueWearCategoryDto>() {
            @Override
            public MBoutiqueWearCategoryDto apply(MBoutiqueWearCategory mBoutiqueWearCategory) {
                return MBoutiqueWearCategoryDto.builder()
                        .id(mBoutiqueWearCategory.getId())
                        .categoryId(mBoutiqueWearCategory.getCategoryId())
                        .categoryName(mBoutiqueWearCategory.getCategoryName())
                        .nameInLocal(mBoutiqueWearCategory.getNameInLocal())
                        .status(mBoutiqueWearCategory.isStatus())
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
                        .boutiqueWearId(mBoutiqueWear.getBoutiqueWearId())
                        .categoryId(mBoutiqueWear.getCategoryId())
                        .typeOfWear(mBoutiqueWear.getTypeOfWear())
                        .nameInLocal(mBoutiqueWear.getNameInLocal())
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
                        .boutiqueWearBrandId(mBoutiqueWearBrand.getBoutiqueWearBrandId())
                        .categoryId(mBoutiqueWearBrand.getCategoryId())
                        .brandName(mBoutiqueWearBrand.getBrandName())
                        .nameInLocal(mBoutiqueWearBrand.getNameInLocal())
                        .status(mBoutiqueWearBrand.isStatus())
                        .build();
            }
        };
    }

    //=========================================== Textile Wear Category Converter Function ======================================================

    public Function<MTextileWearCategory, MTextileWearCategoryDto> fromTextileWearCategory() {
        return new Function<MTextileWearCategory, MTextileWearCategoryDto>() {
            @Override
            public MTextileWearCategoryDto apply(MTextileWearCategory mTextileWearCategory) {
                return MTextileWearCategoryDto.builder()
                        .id(mTextileWearCategory.getId())
                        .categoryId(mTextileWearCategory.getCategoryId())
                        .categoryName(mTextileWearCategory.getCategoryName())
                        .nameInLocal(mTextileWearCategory.getNameInLocal())
                        .status(mTextileWearCategory.isStatus())
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
                        .textileWearId(mTextileWear.getTextileWearId())
                        .categoryId(mTextileWear.getCategoryId())
                        .typeOfWear(mTextileWear.getTypeOfWear())
                        .nameInLocal(mTextileWear.getNameInLocal())
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
                        .textileWearBrandId(mTextileWearBrand.getTextileWearBrandId())
                        .categoryId(mTextileWearBrand.getCategoryId())
                        .brandName(mTextileWearBrand.getBrandName())
                        .nameInLocal(mTextileWearBrand.getNameInLocal())
                        .status(mTextileWearBrand.isStatus())
                        .build();
            }
        };
    }
}
