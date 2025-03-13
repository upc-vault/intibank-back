package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.ServiceType;

import java.util.List;


//Capa para realizar la consulta a la base de datos:
public interface IServiceTypeRepositorio extends JpaRepository<ServiceType, Long> {



   //List<ServiceType> ListarTipoServicio();

}
