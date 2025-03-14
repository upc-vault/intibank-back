package pe.edu.upc.intibank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.service.IBankUserNegocio;
import pe.edu.upc.intibank.service.impl.BankUserNegocio;

import java.util.List;

@RestController
@RequestMapping("/intibank")
public class BankUserRest {

    @Autowired
    private IBankUserNegocio bankUserNegocio;

    @GetMapping("/usuarios") //http://localhost:8090/intibank/usuarios
    public List<User> listarUsuarioBanco() {
        return bankUserNegocio.listarUsuarioBanco();
    }

    @GetMapping("/usuarios/{email}") //http://localhost:8090/intibank/usuarios/{email}
    public List<User> buscarUsuarioBancoEmail(@PathVariable(value = "email") String email) {
        return bankUserNegocio.listarUsuarioBancoPorEmail(email);
    }

}
