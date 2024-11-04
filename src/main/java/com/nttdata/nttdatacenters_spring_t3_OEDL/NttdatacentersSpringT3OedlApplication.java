package com.nttdata.nttdatacenters_spring_t3_OEDL;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.nttdata.nttdatacenters_spring_t3_OEDL.model.Cliente;
import com.nttdata.nttdatacenters_spring_t3_OEDL.service.ClienteService;

@SpringBootApplication
public class NttdatacentersSpringT3OedlApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT3OedlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    // Crear y guardar tres nuevos clientes
	    Cliente cliente1 = new Cliente();
	    cliente1.setNombre("Juan");
	    cliente1.setApellidos("Pérez");
	    cliente1.setFechaNacimiento(LocalDate.of(1990, 1, 1));
	    cliente1.setNumeroDocumento("12345678");
	    clienteService.guardarCliente(cliente1);

	    Cliente cliente2 = new Cliente();
	    cliente2.setNombre("Ana");
	    cliente2.setApellidos("García");
	    cliente2.setFechaNacimiento(LocalDate.of(1985, 5, 15));
	    cliente2.setNumeroDocumento("87654321");
	    clienteService.guardarCliente(cliente2);

	    Cliente cliente3 = new Cliente();
	    cliente3.setNombre("Luis");
	    cliente3.setApellidos("Martínez");
	    cliente3.setFechaNacimiento(LocalDate.of(1978, 8, 20));
	    cliente3.setNumeroDocumento("11223344");
	    clienteService.guardarCliente(cliente3);

	    // Buscar cliente por nombre y apellidos
	    System.out.println("Buscar cliente por nombre y apellidos:");
	    clienteService.buscarPorNombreYApellidos("Juan", "Pérez").forEach(cliente -> 
	        System.out.println(cliente.getNombre() + " " + cliente.getApellidos())
	    );

	    // Obtener todos los clientes
	    System.out.println("Listar todos los clientes:");
	    clienteService.obtenerTodosLosClientes().forEach(cliente -> 
	        System.out.println(cliente.getNombre() + " " + cliente.getApellidos())
	    );

	    // Eliminar cliente por ID
	    System.out.println("Eliminar cliente con ID: " + cliente1.getId());
	    clienteService.eliminarCliente(cliente1.getId());

	    // Listar todos los clientes después de la eliminación
	    System.out.println("Listar todos los clientes después de la eliminación:");
	    clienteService.obtenerTodosLosClientes().forEach(cliente -> 
	        System.out.println(cliente.getNombre() + " " + cliente.getApellidos())
	    );
	}


}
