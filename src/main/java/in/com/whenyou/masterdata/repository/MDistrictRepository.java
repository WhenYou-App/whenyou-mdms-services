package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MDistrictRepository extends JpaRepository<MDistrict, UUID> {
    public Optional<MDistrict> findByDistrictId(Long id);

    public Optional<MDistrict> findByStatus(boolean status);
}
