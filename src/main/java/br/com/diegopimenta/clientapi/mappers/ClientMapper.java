package br.com.diegopimenta.clientapi.mappers;

import br.com.diegopimenta.clientapi.dto.ClientDTO;
import br.com.diegopimenta.clientapi.models.Client;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ClientMapper {

    public Client dtoToEntity(ClientDTO dto) {

        if (dto.getId() == null) {
            Client client = new Client();
            client.setName(dto.getName());
            client.setCpf(dto.getCpf());
            client.setCreatedDate(dto.getCreatedDate());

            return client;
        }

        Client client = new Client();
        client.setId(client.getId());
        client.setName(client.getName());
        client.setCpf(client.getCpf());
        client.setCreatedDate(client.getCreatedDate());

        return client;
    }

    public ClientDTO entityToDto(Client entity) {

        if (entity == null) return null;

        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }
}
