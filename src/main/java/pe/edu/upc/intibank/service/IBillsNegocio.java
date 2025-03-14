package pe.edu.upc.intibank.service;

import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.entity.User;

import java.util.List;

public interface IBillsNegocio {

    public List<Bills> listarBillsPorSuministro(String sumi);

}
