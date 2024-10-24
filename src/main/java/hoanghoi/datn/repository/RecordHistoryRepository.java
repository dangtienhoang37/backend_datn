package hoanghoi.datn.repository;

import hoanghoi.datn.entity.RecordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RecordHistoryRepository extends JpaRepository<RecordHistory, UUID> {
}
