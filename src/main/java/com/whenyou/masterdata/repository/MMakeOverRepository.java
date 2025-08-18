package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MMakeOver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface MMakeOverRepository extends JpaRepository<MMakeOver, UUID> {
    public Optional<MMakeOver> findByExcelId(Long excelId);
}
