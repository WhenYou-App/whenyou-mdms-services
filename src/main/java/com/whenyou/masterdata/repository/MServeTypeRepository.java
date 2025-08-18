package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MServeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MServeTypeRepository extends JpaRepository<MServeType, UUID> {
    public Optional<MServeType> findByExcelId(Long excelId);
}
