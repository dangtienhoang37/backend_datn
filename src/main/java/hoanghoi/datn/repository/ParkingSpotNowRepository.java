package hoanghoi.datn.repository;

import hoanghoi.datn.entity.ParkingSpotNow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ParkingSpotNowRepository extends JpaRepository<ParkingSpotNow,UUID> {
}
