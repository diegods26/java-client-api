package br.com.diegopimenta.clientapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column
    private BigDecimal price;

}
