package com.whenyou.masterdata.service;

import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.repository.MDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {

    @Autowired
    private MDistrictRepository mDistrictRepository;

    public List<MDistrict> getMDistricts() {
        return mDistrictRepository.findAll();
    }
}
