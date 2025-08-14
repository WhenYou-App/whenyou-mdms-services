package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MDistrictRepository extends JpaRepository<MDistrict, Long> {

}
