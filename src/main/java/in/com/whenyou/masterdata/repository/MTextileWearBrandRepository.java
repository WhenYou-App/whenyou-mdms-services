package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MTextileWearBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MTextileWearBrandRepository extends JpaRepository<MTextileWearBrand, UUID> {
    public Optional<MTextileWearBrand> findByTextileWearBrandId(Long excelId);

    public List<MTextileWearBrand> findByStatusAndCategoryId(boolean status, Long categoryId);
}
