package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MVehicleRepository extends JpaRepository<MVehicle, UUID> {
    public Optional<MVehicle> findByExcelId(Long excelId);

    public List<MVehicle> findByStatus(boolean status);
    public List<MVehicle> findByStatusAndBrandNameIgnoreCase(boolean status, String brandName);
    public List<MVehicle> findByStatusAndModelNameIgnoreCase(boolean status, String modelName);
    public List<MVehicle> findByStatusAndModelTypeIgnoreCase(boolean status, String modelType);
    public List<MVehicle> findByStatusAndModelTypeIgnoreCaseAndModelNameIgnoreCase(boolean status, String modelType, String modelName);
    public List<MVehicle> findByStatusAndBrandNameIgnoreCaseAndModelNameIgnoreCase(boolean status, String brandName, String modelName);
    public List<MVehicle> findByStatusAndBrandNameIgnoreCaseAndModelTypeIgnoreCase(boolean status, String brandName, String modelType);
    public List<MVehicle> findByStatusAndBrandNameIgnoreCaseAndModelTypeIgnoreCaseAndModelNameIgnoreCase(boolean status, String brandName, String modelType, String modelName);
}
