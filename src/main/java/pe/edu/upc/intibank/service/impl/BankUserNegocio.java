package pe.edu.upc.intibank.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.repository.IBankUserRepositorio;
import pe.edu.upc.intibank.service.IBankUserNegocio;

import java.util.List;

@Service
public class BankUserNegocio implements IBankUserNegocio {

    @Autowired
    IBankUserRepositorio ibankUserRepositorio;

    @Override
    public List<User> listarUsuarioBanco() {
        return ibankUserRepositorio.findAll(); //select * from bank_user
    }

    @Override
    public List<User> listarUsuarioBancoPorEmail(String email) {
        return ibankUserRepositorio.findByEmail(email);
    }


}
