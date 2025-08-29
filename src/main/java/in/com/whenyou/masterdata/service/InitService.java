package in.com.whenyou.masterdata.service;

import in.com.whenyou.masterdata.entity.*;
import in.com.whenyou.masterdata.excelutil.ExcelUtility;
import in.com.whenyou.masterdata.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InitService {
    @Autowired MPincodeRepository mPincodeRepository;
    @Autowired MDistrictRepository mDistrictRepository;
    @Autowired MServeTypeRepository mServeTypeRepository;
    @Autowired MTextileWearRepository mTextileWearRepository;
    @Autowired MMakeOverPackageRepository mMakeOverRepository;
    @Autowired MBoutiqueWearRepository mBoutiqueWearRepository;
    @Autowired MVehicleBrandRepository mVehicleBrandRepository;
    @Autowired MFoodCategoryRepository mFoodCategoryRepository;
    @Autowired MJewelMaterialRepository mJewelMaterialRepository;
    @Autowired MTextileWearBrandRepository mTextileWearBrandRepository;
    @Autowired MJewelProductTypeRepository mJewelProductTypeRepository;
    @Autowired MMakeOverCategoryRepository mMakeOverCategoryRepository;
    @Autowired MVehicleModelTypeRepository mVehicleModelTypeRepository;
    @Autowired MVehicleModelNameRepository mVehicleModelNameRepository;
    @Autowired MBoutiqueWearBrandRepository mBoutiqueWearBrandRepository;
    @Autowired MJewelMaterialPurityRepository mJewelMaterialPurityRepository;
    @Autowired MTextileWearCategoryRepository mTextileWearCategoryRepository;
    @Autowired MBoutiqueWearCategoryRepository mBoutiqueWearCategoryRepository;

    @Transactional
    public void initData(MultipartFile districtsFile, MultipartFile pincodesFile,
                         MultipartFile vehicleBrandsFile, MultipartFile vehicleModelTypesFile, MultipartFile vehicleModelNamesFile,
                         MultipartFile jewelsFile, MultipartFile jewelMaterialsFile, MultipartFile jewelMaterialPuritiesFile,
                         MultipartFile serveTypesFile, MultipartFile foodCategoriesFile,
                         MultipartFile makeOverCategoriesFile, MultipartFile makeOverPackagesFile,
                         MultipartFile boutiqueWearCategoriesFile, MultipartFile boutiqueWearsFile, MultipartFile boutiqueWearBrandsFile,
                         MultipartFile textileWearCategoriesFile, MultipartFile textileWearsFile, MultipartFile textileWearBrandsFile) throws IOException {

        // Process Districts if file is present and not empty
        if (districtsFile != null && !districtsFile.isEmpty()) {
            List<MDistrict> districts = ExcelUtility.excelToDistricts(districtsFile.getInputStream());
            for (MDistrict district : districts) {
                mDistrictRepository.findByDistrictId(district.getDistrictId())
                        .ifPresentOrElse(existing -> {
                            existing.setName(district.getName());
                            existing.setNameInLocal(district.getNameInLocal());
                            existing.setStatus(district.isStatus());
                            mDistrictRepository.save(existing);
                        }, () -> {
                            // New district entry
                            district.setId(null); // Let UUID be auto-generated
                            mDistrictRepository.save(district);
                        });
            }
        }

        // Process Pincodes if file is present and not empty
        if (pincodesFile != null && !pincodesFile.isEmpty()) {
            List<MPincode> pincodes = ExcelUtility.excelToPincodes(pincodesFile.getInputStream());
            for (MPincode pincode : pincodes) {
                mPincodeRepository.findByPincodeId(pincode.getPincodeId())
                        .ifPresentOrElse(existing -> {
                            existing.setDistrictId(pincode.getDistrictId());
                            existing.setName(pincode.getName());
                            existing.setNameInLocal(pincode.getNameInLocal());
                            existing.setPincode(pincode.getPincode());
                            existing.setStatus(pincode.isStatus());
                            mPincodeRepository.save(existing);
                        }, () -> {
                            // New pincode entry
                            pincode.setId(null); // Let UUID be auto-generated
                            mPincodeRepository.save(pincode);
                        });
            }
        }

        // Process Vehicle if file is present and not empty
        if (vehicleBrandsFile != null && !vehicleBrandsFile.isEmpty()) {
            List<MVehicleBrand> vehicles = ExcelUtility.excelToVehicleBrands(vehicleBrandsFile.getInputStream());
            for (MVehicleBrand vehicle : vehicles) {
                mVehicleBrandRepository.findByBrandId(vehicle.getBrandId())
                        .ifPresentOrElse(existing -> {
                            existing.setBrandName(vehicle.getBrandName());
                            existing.setNameInLocal(vehicle.getNameInLocal());
                            existing.setStatus(vehicle.isStatus());
                            mVehicleBrandRepository.save(existing);
                        }, () -> {
                            vehicle.setId(null);
                            mVehicleBrandRepository.save(vehicle);
                        });
            }
        }

        // Process Vehicle Model Type if file is present and not empty
        if (vehicleModelTypesFile != null && !vehicleModelTypesFile.isEmpty()) {
            List<MVehicleModelType> modelTypes = ExcelUtility.excelToVehicleModelTypes(vehicleModelTypesFile.getInputStream());
            for (MVehicleModelType modelType : modelTypes) {
                mVehicleModelTypeRepository.findByModelTypeId(modelType.getModelTypeId())
                        .ifPresentOrElse(existing -> {
                            existing.setModelTypeName(modelType.getModelTypeName());
                            existing.setNameInLocal(modelType.getNameInLocal());
                            existing.setStatus(modelType.isStatus());
                            mVehicleModelTypeRepository.save(existing);
                        }, () -> {
                            modelType.setId(null);
                            mVehicleModelTypeRepository.save(modelType);
                        });
            }
        }

        // Process Vehicle Model Name if file is present and not empty
        if (vehicleModelNamesFile != null && !vehicleModelNamesFile.isEmpty()) {
            List<MVehicleModelName> modelNames = ExcelUtility.excelToVehicleModelNames(vehicleModelNamesFile.getInputStream());
            for (MVehicleModelName modelName : modelNames) {
                mVehicleModelNameRepository.findByModelNameId(modelName.getModelNameId())
                        .ifPresentOrElse(existing -> {
                            existing.setBrandId(modelName.getBrandId());
                            existing.setModelTypeId(modelName.getModelTypeId());
                            existing.setModelName(modelName.getModelName());
                            existing.setNameInLocal(modelName.getNameInLocal());
                            existing.setStatus(modelName.isStatus());
                            mVehicleModelNameRepository.save(existing);
                        }, () -> {
                            modelName.setId(null);
                            mVehicleModelNameRepository.save(modelName);
                        });
            }
        }

        // Process Jewels
        if (jewelsFile != null && !jewelsFile.isEmpty()) {
            List<MJewelProductType> jewels = ExcelUtility.excelToJewels(jewelsFile.getInputStream());
            for (MJewelProductType jewel : jewels) {
                mJewelProductTypeRepository.findByJewelProductTypeId(jewel.getJewelProductTypeId())
                        .ifPresentOrElse(existing -> {
                            existing.setProductTypeName(jewel.getProductTypeName());
                            existing.setNameInLocal(jewel.getNameInLocal());
                            existing.setStatus(jewel.isStatus());
                            mJewelProductTypeRepository.save(existing);
                        }, () -> {
                            jewel.setId(null);
                            mJewelProductTypeRepository.save(jewel);
                        });
            }
        }

        // Process Jewel Materials
        if (jewelMaterialsFile != null && !jewelMaterialsFile.isEmpty()) {
            List<MJewelMaterial> jewelMaterials = ExcelUtility.excelToJewelMaterials(jewelMaterialsFile.getInputStream());
            for (MJewelMaterial jewelMaterial : jewelMaterials) {
                mJewelMaterialRepository.findByJewelMaterialId(jewelMaterial.getJewelMaterialId())
                        .ifPresentOrElse(existing -> {
                            existing.setMaterialName(jewelMaterial.getMaterialName());
                            existing.setNameInLocal(jewelMaterial.getNameInLocal());
                            existing.setStatus(jewelMaterial.isStatus());
                            mJewelMaterialRepository.save(existing);
                        }, () -> {
                            jewelMaterial.setId(null);
                            mJewelMaterialRepository.save(jewelMaterial);
                        });
            }
        }

        // Process Jewel Material purities
        if (jewelMaterialPuritiesFile != null && !jewelMaterialPuritiesFile.isEmpty()) {
            List<MJewelMaterialPurity> jewelMaterialPurities = ExcelUtility.excelToJewelMaterialPurities(jewelMaterialPuritiesFile.getInputStream());
            for (MJewelMaterialPurity jewelMaterialPurity : jewelMaterialPurities) {
                mJewelMaterialPurityRepository.findByJewelMaterialPurityId(jewelMaterialPurity.getJewelMaterialPurityId())
                        .ifPresentOrElse(existing -> {
                            existing.setJewelMaterialId(jewelMaterialPurity.getJewelMaterialId());
                            existing.setMaterialPurity(jewelMaterialPurity.getMaterialPurity());
                            existing.setStatus(jewelMaterialPurity.isStatus());
                            mJewelMaterialPurityRepository.save(existing);
                        }, () -> {
                            jewelMaterialPurity.setId(null);
                            mJewelMaterialPurityRepository.save(jewelMaterialPurity);
                        });
            }
        }

        // Process Serve Types
        if (serveTypesFile != null && !serveTypesFile.isEmpty()) {
            List<MServeType> serveTypes = ExcelUtility.excelToServeTypes(serveTypesFile.getInputStream());
            for (MServeType serveType : serveTypes) {
                mServeTypeRepository.findByServeTypeId(serveType.getServeTypeId())
                        .ifPresentOrElse(existing -> {
                            existing.setServeType(serveType.getServeType());
                            existing.setNameInLocal(serveType.getNameInLocal());
                            existing.setStatus(serveType.isStatus());
                            mServeTypeRepository.save(existing);
                        }, () -> {
                            serveType.setId(null);
                            mServeTypeRepository.save(serveType);
                        });
            }
        }

        // process Food Categories
        if (foodCategoriesFile != null && !foodCategoriesFile.isEmpty()) {
            List<MFoodCategory> foodCategories = ExcelUtility.excelToFoodCategories(foodCategoriesFile.getInputStream());
            for (MFoodCategory category : foodCategories) {
                mFoodCategoryRepository.findByCategoryId(category.getCategoryId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryName(category.getCategoryName());
                            existing.setNameInLocal(category.getNameInLocal());
                            existing.setStatus(category.isStatus());
                            mFoodCategoryRepository.save(existing);
                        }, () -> {
                            category.setId(null);
                            mFoodCategoryRepository.save(category);
                        });
            }
        }

        // Process Make Over Categories
        if (makeOverCategoriesFile != null && !makeOverCategoriesFile.isEmpty()) {
            List<MMakeOverCategory> makeOverCategories = ExcelUtility.excelToMakeOverCategories(makeOverCategoriesFile.getInputStream());
            for (MMakeOverCategory makeOver : makeOverCategories) {
                mMakeOverCategoryRepository.findByCategoryId(makeOver.getCategoryId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryName(makeOver.getCategoryName());
                            existing.setNameInLocal(makeOver.getNameInLocal());
                            existing.setStatus(makeOver.isStatus());
                            mMakeOverCategoryRepository.save(existing);
                        }, () -> {
                            makeOver.setId(null);
                            mMakeOverCategoryRepository.save(makeOver);
                        });
            }
        }

        // Process Make Over Packages
        if (makeOverPackagesFile != null && !makeOverPackagesFile.isEmpty()) {
            List<MMakeOverPackage> makeOverPackages = ExcelUtility.excelToMakeOvers(makeOverPackagesFile.getInputStream());
            for (MMakeOverPackage makeOverPackage : makeOverPackages) {
                mMakeOverRepository.findByPackageId(makeOverPackage.getPackageId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryId(makeOverPackage.getCategoryId());
                            existing.setPackageName(makeOverPackage.getPackageName());
                            existing.setNameInLocal(makeOverPackage.getNameInLocal());
                            existing.setStatus(makeOverPackage.isStatus());
                            mMakeOverRepository.save(existing);
                        }, () -> {
                            makeOverPackage.setId(null);
                            mMakeOverRepository.save(makeOverPackage);
                        });
            }
        }

        // Process Boutique Wear Categories
        if (boutiqueWearCategoriesFile != null && !boutiqueWearCategoriesFile.isEmpty()) {
            List<MBoutiqueWearCategory> boutiqueWearCategories = ExcelUtility.excelToBoutiqueWearCategories(boutiqueWearCategoriesFile.getInputStream());
            for (MBoutiqueWearCategory category : boutiqueWearCategories) {
                mBoutiqueWearCategoryRepository.findByCategoryId(category.getCategoryId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryName(category.getCategoryName());
                            existing.setNameInLocal(category.getNameInLocal());
                            existing.setStatus(category.isStatus());
                            mBoutiqueWearCategoryRepository.save(existing);
                        }, () -> {
                            category.setId(null);
                            mBoutiqueWearCategoryRepository.save(category);
                        });
            }
        }

        // Process Boutique Wears
        if (boutiqueWearsFile != null && !boutiqueWearsFile.isEmpty()) {
            List<MBoutiqueWear> boutiqueWears = ExcelUtility.excelToBoutiqueWears(boutiqueWearsFile.getInputStream());
            for (MBoutiqueWear boutiqueWear : boutiqueWears) {
                mBoutiqueWearRepository.findByBoutiqueWearId(boutiqueWear.getBoutiqueWearId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryId(boutiqueWear.getCategoryId());
                            existing.setTypeOfWear(boutiqueWear.getTypeOfWear());
                            existing.setNameInLocal(boutiqueWear.getNameInLocal());
                            existing.setStatus(boutiqueWear.isStatus());
                            mBoutiqueWearRepository.save(existing);
                        }, () -> {
                            boutiqueWear.setId(null);
                            mBoutiqueWearRepository.save(boutiqueWear);
                        });
            }
        }

        // Process Boutique Wear Brands
        if (boutiqueWearBrandsFile != null && !boutiqueWearBrandsFile.isEmpty()) {
            List<MBoutiqueWearBrand> brands = ExcelUtility.excelToBoutiqueWearBrands(boutiqueWearBrandsFile.getInputStream());
            for (MBoutiqueWearBrand brand : brands) {
                mBoutiqueWearBrandRepository.findByBoutiqueWearBrandId(brand.getBoutiqueWearBrandId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryId(brand.getCategoryId());
                            existing.setBrandName(brand.getBrandName());
                            existing.setNameInLocal(brand.getNameInLocal());
                            existing.setStatus(brand.isStatus());
                            mBoutiqueWearBrandRepository.save(existing);
                        }, () -> {
                            brand.setId(null);
                            mBoutiqueWearBrandRepository.save(brand);
                        });
            }
        }

        // process Textile Wear Categories
        if (textileWearCategoriesFile != null && !textileWearCategoriesFile.isEmpty()) {
            List<MTextileWearCategory> textileWearCategories = ExcelUtility.excelToTextileWearCategories(textileWearCategoriesFile.getInputStream());
            for (MTextileWearCategory category : textileWearCategories) {
                mTextileWearCategoryRepository.findByCategoryId(category.getCategoryId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryName(category.getCategoryName());
                            existing.setNameInLocal(category.getNameInLocal());
                            existing.setStatus(category.isStatus());
                            mTextileWearCategoryRepository.save(existing);
                        }, () -> {
                            category.setId(null);
                            mTextileWearCategoryRepository.save(category);
                        });
            }
        }

        // Process Textile Wears
        if (textileWearsFile != null && !textileWearsFile.isEmpty()) {
            List<MTextileWear> textileWears = ExcelUtility.excelToTextileWears(textileWearsFile.getInputStream());
            for (MTextileWear textileWear : textileWears) {
                mTextileWearRepository.findByTextileWearId(textileWear.getTextileWearId())
                        .ifPresentOrElse(existing -> {
                            existing.setTypeOfWear(textileWear.getTypeOfWear());
                            existing.setCategoryId(textileWear.getCategoryId());
                            existing.setNameInLocal(textileWear.getNameInLocal());
                            existing.setStatus(textileWear.isStatus());
                            mTextileWearRepository.save(existing);
                        }, () -> {
                            textileWear.setId(null);
                            mTextileWearRepository.save(textileWear);
                        });
            }
        }

        // Process Textile Wear Brands
        if (textileWearBrandsFile != null && !textileWearBrandsFile.isEmpty()) {
            List<MTextileWearBrand> brands = ExcelUtility.excelToTextileWearBrands(textileWearBrandsFile.getInputStream());
            for (MTextileWearBrand brand : brands) {
                mTextileWearBrandRepository.findByTextileWearBrandId(brand.getTextileWearBrandId())
                        .ifPresentOrElse(existing -> {
                            existing.setCategoryId(brand.getCategoryId());
                            existing.setBrandName(brand.getBrandName());
                            existing.setNameInLocal(brand.getNameInLocal());
                            existing.setStatus(brand.isStatus());
                            mTextileWearBrandRepository.save(existing);
                        }, () -> {
                            brand.setId(null);
                            mTextileWearBrandRepository.save(brand);
                        });
            }
        }
    }
}
