package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Account;
import hoanghoi.datn.entity.District;
import hoanghoi.datn.entity.Parking;
import hoanghoi.datn.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, UUID> {

    List<Parking> findAllByWard(Ward ward);

    List<Parking> findAllByDistrict(District district);
    List<Parking> findAllByAccount(Account account);
    Parking findByDeviceId(UUID deviceId);
//    List<Parking> findByDistrictId(String id);

}
