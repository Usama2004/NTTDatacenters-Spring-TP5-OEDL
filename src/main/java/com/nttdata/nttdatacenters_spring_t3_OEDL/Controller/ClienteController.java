package com.nttdata.nttdatacenters_spring_t3_OEDL.Controller;

import com.nttdata.nttdatacenters_spring_t3_OEDL.model.Cliente;

import com.nttdata.nttdatacenters_spring_t3_OEDL.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        model.addAttribute("clientes", clientes);
        return "clientes/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/nuevo";
    }

    @PostMapping
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "clientes/nuevo";
        }
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/buscar")
    public String mostrarFormularioDeBusqueda() {
        return "clientes/buscar";
    }

    @PostMapping("/buscar")
    public String buscarClientePorNombre(@RequestParam("nombre") String nombre, Model model) {
        System.out.println("Buscando clientes con nombre: " + nombre);
        List<Cliente> clientes = clienteService.buscarPorNombre(nombre);
        System.out.println("Clientes encontrados: " + clientes.size());
        model.addAttribute("clientes", clientes);
        return "clientes/listar";
    }

    @PostMapping("/buscarPorApellidos")
    public String buscarClientePorApellidos(@RequestParam("apellidos") String apellidos, Model model) {
        System.out.println("Buscando clientes con apellidos: " + apellidos);
        List<Cliente> clientes = clienteService.buscarPorApellidos(apellidos);
        System.out.println("Clientes encontrados: " + clientes.size());
        model.addAttribute("clientes", clientes);
        return "clientes/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
