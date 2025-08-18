package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MJewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MJewelRepository extends JpaRepository<MJewel, UUID> {
    public Optional<MJewel> findByExcelId(Long excelId);
}
