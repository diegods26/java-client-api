package br.com.diegopimenta.clientapi.validation;

import br.com.diegopimenta.clientapi.exceptions.DuplicateRecordException;
import br.com.diegopimenta.clientapi.models.Client;
import br.com.diegopimenta.clientapi.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientValidation {

    private final ClientRepository repository;

    public void clientValidation(Client client) {
        if (isClientTaken(client.getEmail()))
            throw new DuplicateRecordException("Usuário já cadastrado!");
    }

    private Boolean isClientTaken(String email) {
        var client = repository.findByEmail(email);
        return client.isPresent();
    }
}
