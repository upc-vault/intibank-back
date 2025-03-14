package pe.edu.upc.intibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.entity.ServiceType;
import pe.edu.upc.intibank.service.IServiceTypeNegocio;

import java.util.List;


@RestController
@RequestMapping("/intibank")
public class ServiceTypeRest {

    @Autowired
    private IServiceTypeNegocio serviceTypeNegocio;

    @GetMapping("/servicios") //http://localhost:8090/intibank/servicios
    public List<ServiceType> listarTipoServicio() {
        return serviceTypeNegocio.listarTipoServicio();
    }

    @GetMapping("/tiposervicio/{id}") //http://localhost:8090/intibank/tiposervicio/{id}
    public ServiceType buscarTipoServicioPorTipo(@PathVariable(value = "id") Long id) {
        return serviceTypeNegocio.buscarTipoServicioPorTipo(id);
    }

}
