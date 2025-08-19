package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MJewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MJewelRepository extends JpaRepository<MJewel, UUID> {
    public Optional<MJewel> findByExcelId(Long excelId);

    public List<MJewel> findByStatus(boolean status);
}
