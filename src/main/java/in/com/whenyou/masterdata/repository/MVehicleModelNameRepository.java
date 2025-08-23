package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MVehicleModelName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MVehicleModelNameRepository extends JpaRepository<MVehicleModelName, UUID> {
    public List<MVehicleModelName> findByStatus(boolean status);
    public List<MVehicleModelName> findByStatusAndModelTypeId(boolean status, Long modelTypeId);
    public List<MVehicleModelName> findByStatusAndBrandId(boolean status, Long brandId);
    public List<MVehicleModelName> findByStatusAndBrandIdAndModelTypeId(boolean status, Long brandId, Long modelTypeId);

    public Optional<MVehicleModelName> findByModelNameId(Long modelNameId);
}
