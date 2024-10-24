package hoanghoi.datn.entity;

import hoanghoi.datn.enumvar.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String PID;
    private String email;
    private String address;
    private String userImg;
    private String userRecordHistoryId;

}
