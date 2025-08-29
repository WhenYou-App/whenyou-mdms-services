package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MBoutiqueWearBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MBoutiqueWearBrandRepository extends JpaRepository<MBoutiqueWearBrand, UUID> {
    public Optional<MBoutiqueWearBrand> findByBoutiqueWearBrandId(Long excelId);

    public List<MBoutiqueWearBrand> findByStatusAndCategoryId(boolean status, Long categoryId);
}
