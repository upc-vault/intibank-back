package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.entity.User;

import java.util.List;

public interface IBillsRepositorio extends JpaRepository<Bills, Long> {

    List<Bills> findByNumeroSuministro(String suministro);

}
