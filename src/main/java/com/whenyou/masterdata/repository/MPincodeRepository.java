package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MPincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MPincodeRepository extends JpaRepository<MPincode, UUID> {
    public Optional<MPincode> findByExcelId(Long excelId);

    public List<MPincode> findByStatus(boolean status);
}
