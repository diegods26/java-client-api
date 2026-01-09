package br.com.diegopimenta.clientapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "create_date")
    private LocalDate createdDate;
}
