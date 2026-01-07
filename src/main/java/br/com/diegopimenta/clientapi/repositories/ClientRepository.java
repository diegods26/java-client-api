package br.com.diegopimenta.clientapi.repositories;

import br.com.diegopimenta.clientapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
