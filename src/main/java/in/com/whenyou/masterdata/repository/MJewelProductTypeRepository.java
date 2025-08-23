package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MJewelProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MJewelProductTypeRepository extends JpaRepository<MJewelProductType, UUID> {
    public Optional<MJewelProductType> findByJewelProductTypeId(Long excelId);

    public List<MJewelProductType> findByStatus(boolean status);
}
