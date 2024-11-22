package hoanghoi.datn.repository;

import hoanghoi.datn.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
//    @Query("SELECT d FROM District d " +
//            "LEFT JOIN FETCH d.wards " +
//            "WHERE d.id = :districtId")
//    Optional<District> findDistrictWithWardsById(@Param("districtId") String districtId);
}
