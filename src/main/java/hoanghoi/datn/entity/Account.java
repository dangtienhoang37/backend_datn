package hoanghoi.datn.entity;

import hoanghoi.datn.enumvar.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private UUID idUser;
    @Builder.Default
    private boolean isActive=true;
    @Column(nullable = false)
    @Builder.Default
    private boolean init = true;


}
