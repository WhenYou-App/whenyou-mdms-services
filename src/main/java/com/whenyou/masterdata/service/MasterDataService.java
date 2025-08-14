package com.whenyou.masterdata.service;

import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.entity.MPincode;
import com.whenyou.masterdata.repository.MDistrictRepository;
import com.whenyou.masterdata.repository.MPincodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {
    @Autowired MPincodeRepository mPincodeRepository;
    @Autowired MDistrictRepository mDistrictRepository;

    public boolean isDistrictsAvailable() {
        return mDistrictRepository.count()>0;
    }

    public boolean isPincodesAvailable() {
        return mPincodeRepository.count()>0;
    }

    public void createDistricts(List<MDistrict> mDistricts) {
        mDistrictRepository.saveAll(mDistricts);
    }

    public void createPincodes(List<MPincode> mPincodes) {
        mPincodeRepository.saveAll(mPincodes);
    }

    public List<MDistrict> getMDistricts() {
        return mDistrictRepository.findAll();
    }

    public List<MPincode> getMPincodes() {
        return mPincodeRepository.findAll();
    }
}
