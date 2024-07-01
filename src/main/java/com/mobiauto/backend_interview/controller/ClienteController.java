package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.dto.ClienteDTO;
import com.mobiauto.backend_interview.entities.Cliente;
import com.mobiauto.backend_interview.repository.ClienteRepository;
import com.mobiauto.backend_interview.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/criar")
    public ResponseEntity criarCliente(@RequestBody @Valid ClienteDTO body) {
        if (this.clienteRepository.findByEmail(body.getEmail()) != null) {
            return ResponseEntity.badRequest().body("E-mail já está em uso.");
        }
        Cliente newCliente = new Cliente(body);
        this.clienteRepository.save(newCliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(this.clienteService.listarCliente());
    }

    @PutMapping("/atualizar/{clienteId}")
    public ResponseEntity atualizarCliente(@PathVariable Long clienteId, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = this.clienteService.atualizarCliente(clienteId, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
