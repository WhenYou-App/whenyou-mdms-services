package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MVehicleModelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MVehicleModelTypeRepository extends JpaRepository<MVehicleModelType, UUID> {
    public List<MVehicleModelType> findByStatus(boolean status);

    public Optional<MVehicleModelType> findByModelTypeId(Long modelTypeId);
}
