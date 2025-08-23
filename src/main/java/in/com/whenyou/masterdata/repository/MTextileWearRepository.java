package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MTextileWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MTextileWearRepository extends JpaRepository<MTextileWear, UUID> {
    public Optional<MTextileWear> findByTextileWearId(Long excelId);

    public List<MTextileWear> findByStatusAndCategoryId(boolean status, Long categoryId);

}
