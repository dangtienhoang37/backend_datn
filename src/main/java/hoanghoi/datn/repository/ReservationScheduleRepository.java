package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Account;
import hoanghoi.datn.entity.Parking;
import hoanghoi.datn.entity.ReservationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ReservationScheduleRepository extends JpaRepository<ReservationSchedule, UUID> {
    Optional<ReservationSchedule> findByAccount(Account existedAcc);

    List<ReservationSchedule> findAllByParking(Parking targetParking);
}
