package pe.edu.upc.intibank.service;

import pe.edu.upc.intibank.entity.User;

import java.util.List;

public interface  IBankUserNegocio {

    public List<User> listarUsuarioBanco();
    public List<User> listarUsuarioBancoPorEmail(String email);



}
