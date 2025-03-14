package pe.edu.upc.intibank.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.mapper.AccountMapper;
import pe.edu.upc.intibank.mapper.BillsMapper;
import pe.edu.upc.intibank.model.bills.BillsResponseModel;
import pe.edu.upc.intibank.repository.AccountRepository;
import pe.edu.upc.intibank.repository.IBillsRepositorio;
import pe.edu.upc.intibank.repository.UserRepository;
import pe.edu.upc.intibank.service.IBillsNegocio;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillsNegocio implements IBillsNegocio {

    @Autowired
    IBillsRepositorio ibillsRepositorio;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BillsMapper billsMapper;


    @Override
    public List<Bills> listarBillsPorSuministro(String sumi) {
        return ibillsRepositorio.findByNumeroSuministro(sumi);
    }

    @Override
    public List<BillsResponseModel> getMyRecibos() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return ibillsRepositorio
                .findAllByUser(user)
                .stream()
                .map(billsMapper::toResponseModel)
                .collect(Collectors.toList());
    }


    @Override
    public List<Bills> findByNumeroSuministroAndEstadoPagoOrderByFechaEmisionAsc(String numeroSuministro, String estadoPago) {
        return ibillsRepositorio.findByNumeroSuministroAndEstadoPagoOrderByFechaEmisionAsc(numeroSuministro, estadoPago);
    }

    @Override
    public Bills save(Bills bill) {
        return ibillsRepositorio.save(bill);
    }

    @Override
    public Bills findById(Long id) {
        return ibillsRepositorio.findById(id).orElse(null);
    }
}
