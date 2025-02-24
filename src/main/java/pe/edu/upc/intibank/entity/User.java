package pe.edu.upc.intibank.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    private String countryCode;

    @Column(unique = true)
    private String phoneNumber;

    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
