package pe.edu.upc.intibank.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.repository.IBillsRepositorio;
import pe.edu.upc.intibank.service.IBillsNegocio;

import java.util.List;

@Service
public class BillsNegocio implements IBillsNegocio {

    @Autowired
    IBillsRepositorio ibillsRepositorio;

    @Override
    public List<Bills> listarBillsPorSuministro(String sumi) {
        return ibillsRepositorio.findByNumeroSuministro(sumi);
    }
}
