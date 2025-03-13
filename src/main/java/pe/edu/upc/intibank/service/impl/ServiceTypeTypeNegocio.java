package pe.edu.upc.intibank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.intibank.entity.ServiceType;
import pe.edu.upc.intibank.repository.IServiceTypeRepositorio;
import pe.edu.upc.intibank.service.IServiceTypeNegocio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeTypeNegocio implements IServiceTypeNegocio {

    @Autowired
    IServiceTypeRepositorio serviceTypeRepositorio;

    @Override
    public List<ServiceType> listarTipoServicio() {
        return serviceTypeRepositorio.findAll();    //select * from TBL_TIPO_SERVICIO
    }








}
