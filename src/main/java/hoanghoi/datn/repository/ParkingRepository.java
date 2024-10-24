package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, UUID> {
}
