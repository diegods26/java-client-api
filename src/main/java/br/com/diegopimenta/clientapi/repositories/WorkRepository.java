package br.com.diegopimenta.clientapi.repositories;

import br.com.diegopimenta.clientapi.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
