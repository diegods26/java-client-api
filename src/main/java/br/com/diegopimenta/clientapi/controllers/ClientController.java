package br.com.diegopimenta.clientapi.controllers;

import br.com.diegopimenta.clientapi.dto.ClientDTO;
import br.com.diegopimenta.clientapi.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping("/add-client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createClient(@RequestBody @Valid ClientDTO request) {
        service.createClient(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllClients() {
        var clients = service.getClients();
        return ResponseEntity.ok(clients);
    }
}
