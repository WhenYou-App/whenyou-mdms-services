package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MVehicleRepository extends JpaRepository<MVehicle, UUID> {
    public Optional<MVehicle> findByExcelId(Long excelId);

    public List<MVehicle> findByStatus(boolean status);
}
