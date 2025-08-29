package in.com.whenyou.masterdata.repository;

import in.com.whenyou.masterdata.entity.MMakeOverPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MMakeOverPackageRepository extends JpaRepository<MMakeOverPackage, UUID> {
    public Optional<MMakeOverPackage> findByPackageId(Long excelId);

    public List<MMakeOverPackage> findByStatusAndCategoryId(boolean status, Long categoryId);
}
