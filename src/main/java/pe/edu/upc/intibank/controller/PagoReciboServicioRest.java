package pe.edu.upc.intibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.service.AccountService;
import pe.edu.upc.intibank.service.IBillsNegocio;

import java.util.List;

@RestController
@RequestMapping("/intibank/pagos")
public class PagoReciboServicioRest {

    @Autowired
    private IBillsNegocio billsService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/recibos/{sumi}")
    public List<Bills> buscarBillsPorSuministro(@PathVariable(value = "sumi") String sumi) {
        return billsService.listarBillsPorSuministro(sumi);
    }

    @PostMapping("/pagar")
    public ResponseEntity<ResponseModel> pagarRecibo(@RequestParam Long idRecibo, @RequestParam Long idCuenta) {
        Bills bill = billsService.findById(idRecibo);
        Account account = accountService.findById(idCuenta).orElse(null);

        if (bill == null || account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseModel(HttpStatus.NOT_FOUND, false, null, null, "Recibo o cuenta no encontrado")
            );
        }

        if (bill.getEstadoPago().equalsIgnoreCase("pagado")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseModel(HttpStatus.BAD_REQUEST, false, null, null, "Recibo ya se encuentra pagado")
            );
        }

        if (account.getBalance() < bill.getMonto()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseModel(HttpStatus.BAD_REQUEST, false, null, null, "Saldo insuficiente")
            );
        }

        System.out.println("Antes Saldo de cuenta: " + account.getBalance());
        System.out.println("Antes Monto de recibo: " + bill.getMonto());

        account.setBalance(account.getBalance() - bill.getMonto());

        System.out.println("Después Saldo de cuenta: " + account.getBalance());
        System.out.println("Después Monto de recibo: " + bill.getMonto());

        bill.setEstadoPago("pagado");

        accountService.save(account);
        billsService.save(bill);

        return ResponseEntity.ok(
                new ResponseModel(HttpStatus.OK, true, null, null, "Pago realizado con éxito")
        );
    }

    @GetMapping("/recibos/pendientes")
    public ResponseEntity<Bills> buscarBillsPendientes(@RequestParam String numeroSuministro) {
        List<Bills> bills = billsService.findByNumeroSuministroAndEstadoPagoOrderByFechaEmisionAsc(numeroSuministro, "pendiente");
        if (bills.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(bills.get(0));
    }

    @GetMapping
    public ResponseEntity<ResponseModel> getMyRecibos() {
        return ResponseEntity.ok(
                ResponseModel.builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(billsService.getMyRecibos())
                        .build()
        );
    }
}