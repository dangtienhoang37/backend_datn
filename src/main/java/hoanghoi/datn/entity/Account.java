package hoanghoi.datn.entity;

import hoanghoi.datn.enumvar.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String userName;
    private String password;
    private Role role;
    private String idUser;


}
