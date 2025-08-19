package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MJewelMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MJewelMaterialRepository extends JpaRepository<MJewelMaterial, UUID> {
    public Optional<MJewelMaterial> findByExcelId(Long excelId);

    public List<MJewelMaterial> findByStatus(boolean status);
    public List<MJewelMaterial> findByStatusAndMaterialIgnoreCase(boolean status, String material);
}
