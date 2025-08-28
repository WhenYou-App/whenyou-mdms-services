package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MFoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MFoodCategoryRepository extends JpaRepository<MFoodCategory, UUID> {
    public Optional<MFoodCategory> findByCategoryId(Long categoryId);

    public List<MFoodCategory> findByStatus(boolean status);
}
