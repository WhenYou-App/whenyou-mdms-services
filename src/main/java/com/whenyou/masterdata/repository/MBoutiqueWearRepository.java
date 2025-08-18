package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MBoutiqueWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface MBoutiqueWearRepository extends JpaRepository<MBoutiqueWear, UUID> {
    public Optional<MBoutiqueWear> findByExcelId(Long excelId);
}
