package pe.edu.upc.intibank.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.modelDto.PaymentRequest;
import pe.edu.upc.intibank.repository.AccountRepository;
import pe.edu.upc.intibank.repository.IBillsRepositorio;
import pe.edu.upc.intibank.service.IPaymentNegocio;


import java.util.Collections;
import java.util.List;

@Service
public class PaymentNegocio implements IPaymentNegocio {


    @Autowired
    private IBillsRepositorio iBillsRepositorio;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void processPago(PaymentRequest paymentRequest) {
        Account account = accountRepository.findById(paymentRequest.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Cuenta no encontrada"));

        List<Bills> deudas = iBillsRepositorio.findAllByNumeroSuministroAndEstadoPago("PENDIENTE", paymentRequest.getNumeroSuministro());

        if (deudas.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron deudas pendientes para este suministro");
        }

        Collections.sort(deudas, (b1, b2) -> b1.getFechaVencimiento().compareTo(b2.getFechaVencimiento()));

        Bills deudaMasAntigua = deudas.get(0);

        if (account.getBalance() != null && deudaMasAntigua.getMonto() != null &&
                account.getBalance() < deudaMasAntigua.getMonto()) { // Comparación con <
            throw new RuntimeException("Saldo insuficiente");
        }

        account.setBalance(account.getBalance() - deudaMasAntigua.getMonto()); // Resta con -
        deudaMasAntigua.setEstadoPago("PAGADO");
        //deudaMasAntigua.setFechaPago(LocalDate.now());

        accountRepository.save(account);
        iBillsRepositorio.save(deudaMasAntigua);
    }
}
