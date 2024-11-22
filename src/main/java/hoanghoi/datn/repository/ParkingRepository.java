package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, UUID> {

    List<Parking> findByWardId(String id);
//    List<Parking> findByDistrictId(String id);

}
