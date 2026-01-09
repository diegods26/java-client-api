package br.com.diegopimenta.clientapi.services;

import br.com.diegopimenta.clientapi.dto.ClientDTO;
import br.com.diegopimenta.clientapi.mappers.ClientMapper;
import br.com.diegopimenta.clientapi.models.Client;
import br.com.diegopimenta.clientapi.repositories.ClientRepository;
import br.com.diegopimenta.clientapi.utils.FormatCpf;
import br.com.diegopimenta.clientapi.validation.ClientValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;
    private  final ClientValidation clientValidator;

    public void createClient(ClientDTO dto) {
        Client client = mapper.dtoToEntity(dto);
        clientValidator.clientValidation(client);
        client.setCpf(FormatCpf.removeCpfFormat(dto.getCpf()));
        clientRepository.save(client);
    }

    public List<ClientDTO> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }


}
