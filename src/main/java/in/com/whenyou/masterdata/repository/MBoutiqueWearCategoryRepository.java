package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MBoutiqueWearCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MBoutiqueWearCategoryRepository extends JpaRepository<MBoutiqueWearCategory, UUID> {
    public List<MBoutiqueWearCategory> findByStatus(boolean status);

    public Optional<MBoutiqueWearCategory> findByCategoryId(Long categoryId);
}
