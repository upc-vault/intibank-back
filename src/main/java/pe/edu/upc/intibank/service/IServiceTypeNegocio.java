package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.entity.ServiceType;

import java.util.List;

public interface IServiceTypeNegocio {

    public List<ServiceType> listarTipoServicio();

    public ServiceType buscarTipoServicioPorTipo(Long id);

}
