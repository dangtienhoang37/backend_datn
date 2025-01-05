package hoanghoi.datn.repository;

import hoanghoi.datn.entity.TransactionWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<TransactionWallet, UUID> {
}
