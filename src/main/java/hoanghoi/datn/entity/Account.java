package hoanghoi.datn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hoanghoi.datn.enumvar.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String userName;
    @JsonIgnore
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    User user;
    @Builder.Default
    boolean isActive=true;
    @Column(nullable = false)
    @Builder.Default
    boolean init = true;


}
