package hoanghoi.datn.repository;

import hoanghoi.datn.entity.ReservationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ReservationScheduleRepository extends JpaRepository<ReservationSchedule, UUID> {
}
