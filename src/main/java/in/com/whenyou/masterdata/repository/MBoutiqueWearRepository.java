package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MBoutiqueWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MBoutiqueWearRepository extends JpaRepository<MBoutiqueWear, UUID> {
    public Optional<MBoutiqueWear> findByExcelId(Long excelId);

    public List<MBoutiqueWear> findByStatusAndCategoryIgnoreCase(boolean status, String category);

}
