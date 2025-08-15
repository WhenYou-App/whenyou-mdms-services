package com.whenyou.masterdata.service;

import com.whenyou.masterdata.dto.MDistrictDto;
import com.whenyou.masterdata.dto.MPincodeDto;
import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.entity.MPincode;
import com.whenyou.masterdata.repository.MDistrictRepository;
import com.whenyou.masterdata.repository.MPincodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MasterDataService {
    @Autowired MPincodeRepository mPincodeRepository;
    @Autowired MDistrictRepository mDistrictRepository;

    //=========================================== District Service ======================================================

    public List<MDistrictDto> getActiveDistricts() {
        return mDistrictRepository.findByStatus(true).stream().map(fromDistrict()).collect(Collectors.toList());
    }

    //=========================================== Pincode Service ======================================================

    public List<MPincodeDto> getActivePincodes() {
        return mPincodeRepository.findByStatus(true).stream().map(fromMPincode()).collect(Collectors.toList());
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
}
