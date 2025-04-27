package com.cliente.service;

import com.cliente.model.Cliente;
import com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
    
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }
    
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}