package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MPincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MPincodeRepository extends JpaRepository<MPincode, UUID> {
    public Optional<MPincode> findByPincodeId(Long excelId);

    public List<MPincode> findByStatus(boolean status);
    public List<MPincode> findByStatusAndPincode(boolean status, String pincode);
    public List<MPincode> findByStatusAndDistrictId(boolean status, Long districtId);
    public List<MPincode> findByStatusAndDistrictIdAndPincode(boolean status, Long districtId, String pincode);

}
