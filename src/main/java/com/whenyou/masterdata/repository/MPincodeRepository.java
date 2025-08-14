package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MPincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPincodeRepository extends JpaRepository<MPincode, Long> {
}
