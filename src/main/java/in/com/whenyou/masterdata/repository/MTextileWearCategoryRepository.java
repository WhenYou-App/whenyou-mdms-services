package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MTextileWearCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MTextileWearCategoryRepository extends JpaRepository<MTextileWearCategory, UUID> {
    public List<MTextileWearCategory> findByStatus(boolean status);

    public Optional<MTextileWearCategory> findByCategoryId(Long categoryId);
}
