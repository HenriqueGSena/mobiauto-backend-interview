package com.mobiauto.backend_interview.service;

import com.mobiauto.backend_interview.dto.ClienteDTO;
import com.mobiauto.backend_interview.entities.Cliente;
import com.mobiauto.backend_interview.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO atualizarCliente(Long clienteId, ClienteDTO clienteDTO) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()) {
            Cliente clienteAtualizado = cliente.get();
            clienteAtualizado.setNome(clienteDTO.getNome());
            clienteAtualizado.setEmail(clienteDTO.getEmail());
            clienteAtualizado.setTelefone(clienteDTO.getTelefone());
            return new ClienteDTO(clienteRepository.save(clienteAtualizado));
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    @Transactional
    public List<ClienteDTO> listarCliente() {
        return clienteRepository.findAll().stream()
               .map(ClienteDTO::new)
               .collect(Collectors.toList());
    }
}
