package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MVehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MVehicleBrandRepository extends JpaRepository<MVehicleBrand, UUID> {
    public Optional<MVehicleBrand> findByBrandId(Long excelId);

    public List<MVehicleBrand> findByStatus(boolean status);
}
