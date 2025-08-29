package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MJewelMaterialPurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MJewelMaterialPurityRepository extends JpaRepository<MJewelMaterialPurity, UUID> {
    public List<MJewelMaterialPurity> findByStatusAndJewelMaterialId(boolean status, Long materialId);

    public Optional<MJewelMaterialPurity> findByJewelMaterialPurityId(Long jewelMaterialPurityId);
}
