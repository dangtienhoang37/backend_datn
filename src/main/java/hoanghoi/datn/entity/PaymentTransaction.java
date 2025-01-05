package hoanghoi.datn.entity;


import hoanghoi.datn.enumvar.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "payment_transaction")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    int amount;
    int orderCode;
    @Enumerated(EnumType.ORDINAL)
    PaymentStatus paymentStatus;
    @JoinColumn(name = "walletId", referencedColumnName = "id")
    @ManyToOne
    TransactionWallet transactionWallet;

}
