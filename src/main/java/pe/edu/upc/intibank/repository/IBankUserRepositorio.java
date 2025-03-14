package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.User;

import java.util.List;


//Capa para realizar la consulta a la base de datos:
public interface IBankUserRepositorio extends JpaRepository<User, Long> {


    List<User> findByEmail(String email);
}
