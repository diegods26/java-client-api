package br.com.diegopimenta.clientapi.services;

import br.com.diegopimenta.clientapi.dto.ClientDTO;
import br.com.diegopimenta.clientapi.mappers.ClientMapper;
import br.com.diegopimenta.clientapi.models.Client;
import br.com.diegopimenta.clientapi.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    public ClientDTO createClient(ClientDTO dto) {
        Client client = mapper.dtoToEntity(dto);
        clientRepository.save(client);

        return dto;
    }

    public List<ClientDTO> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }


}
