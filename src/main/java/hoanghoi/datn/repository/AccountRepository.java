package hoanghoi.datn.repository;

import hoanghoi.datn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    boolean existsByUserName(String userName);
    List<Account> findAll();
    Optional<Account> findById(UUID id);
    Optional<Account> findByUserName(String userName);
}
