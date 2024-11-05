package com.nttdata.nttdatacenters_spring_t3_OEDL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nttdata.nttdatacenters_spring_t3_OEDL.model.Cliente;
import com.nttdata.nttdatacenters_spring_t3_OEDL.repository.ClienteRepository;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public List<Cliente> buscarPorApellidos(String apellidos) {
        return clienteRepository.findByApellidos(apellidos);
    }

    public List<Cliente> buscarPorNombreYApellidos(String nombre, String apellidos) {
        return clienteRepository.findByNombreAndApellidos(nombre, apellidos);
    }
}

