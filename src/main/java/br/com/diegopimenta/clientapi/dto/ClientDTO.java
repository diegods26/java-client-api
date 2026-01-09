package br.com.diegopimenta.clientapi.dto;

import br.com.diegopimenta.clientapi.utils.FormatCpf;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {

    private Long id;

    @NotBlank(message = "This field cannot be blank")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    private String cpf;

    @Email(message = "The email is not valid")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

}
