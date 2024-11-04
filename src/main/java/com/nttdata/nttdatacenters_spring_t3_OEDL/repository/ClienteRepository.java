package com.nttdata.nttdatacenters_spring_t3_OEDL.repository;

import com.nttdata.nttdatacenters_spring_t3_OEDL.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	//Extiende JpaRepository para proporcionar métodos CRUD.
	List<Cliente> findByNombre(String nombre);
    List<Cliente> findByApellidos(String apellidos);
    List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);
}
