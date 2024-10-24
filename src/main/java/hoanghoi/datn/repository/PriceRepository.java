package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {
}
