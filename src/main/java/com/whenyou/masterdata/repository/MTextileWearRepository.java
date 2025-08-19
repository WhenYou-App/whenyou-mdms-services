package com.whenyou.masterdata.repository;

import com.whenyou.masterdata.entity.MTextileWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MTextileWearRepository extends JpaRepository<MTextileWear, UUID> {
    public List<MTextileWear> findByStatusAndCategoryIgnoreCase(boolean status, String category);
}
