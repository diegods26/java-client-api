package br.com.diegopimenta.clientapi.mappers;

import br.com.diegopimenta.clientapi.dto.ClientDTO;
import br.com.diegopimenta.clientapi.models.Client;
import br.com.diegopimenta.clientapi.utils.FormatCpf;
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
            client.setEmail(dto.getEmail());
            client.setCreatedDate(dto.getCreatedDate());

            return client;
        }

        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setEmail(dto.getEmail());
        client.setCreatedDate(dto.getCreatedDate());

        return client;
    }

    public ClientDTO entityToDto(Client entity) {

        if (entity == null) return null;

        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(FormatCpf.addCpfFormat(entity.getCpf()));
        dto.setEmail(entity.getEmail());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }
}
