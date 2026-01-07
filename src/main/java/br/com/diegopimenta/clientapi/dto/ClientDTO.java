package br.com.diegopimenta.clientapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    public String getCpf() {
        return cpf.replaceAll(
                "(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                "$1.$2.$3-$4"
        );
    }

}
