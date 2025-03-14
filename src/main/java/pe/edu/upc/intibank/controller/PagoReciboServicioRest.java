package pe.edu.upc.intibank.controller;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.modelDto.PaymentRequest;
import pe.edu.upc.intibank.service.IBillsNegocio;
import pe.edu.upc.intibank.service.IPaymentNegocio;


import java.util.List;

@RestController
@RequestMapping("/intibank/pagos")
public class PagoReciboServicioRest {

    //  PAGO DE SERVICIOS DE LUZ, AGUA, INTERNET
    //  PAGO DE SERVICIOS DE TELEFONÍA MOVIL (CLARO, MOVISTAR, ENTEL, BITEL)

    //  EL PARAMETRO SUMINISTRO ES EL NUMERO DE SUMINISTRO DE LOS RECIBOS DE LUZ, AGUA, INTERNET Y TAMBIÉN ES EL NÚMERO DE TELÉFONO

    @Autowired
    private IBillsNegocio ibillsNegocio;

    @GetMapping("/recibos/{sumi}") //http://localhost:8090/intibank/pagos/recibos/{suministro}
    public List<Bills> buscarBillsPorSuministro(@PathVariable(value = "sumi") String sumi) {
        return ibillsNegocio.listarBillsPorSuministro(sumi);
    }


    //POST PAGAR SERVICIO DE LUZ AGUA, INTERNET
    @Autowired
    private IPaymentNegocio iPaymentNegocio;

    @PostMapping
    public ResponseEntity<ResponseModel> realizarPago(@RequestBody PaymentRequest paymentRequest) {
        try {
            iPaymentNegocio.processPago(paymentRequest);
            return ResponseEntity.ok(
                    ResponseModel.builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data("Pago realizado con éxito")
                            .build()
            );
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ResponseModel.builder()
                            .status(HttpStatus.BAD_REQUEST)
                            .success(false)
                            .data(e.getMessage())
                            .build()
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ResponseModel.builder()
                            .status(HttpStatus.BAD_REQUEST)
                            .success(false)
                            .data(e.getMessage())
                            .build()
            );
        }
    }


    //  PAGO DE TARJETA DE CREDITO

    @GetMapping
    public ResponseEntity<ResponseModel> getMyRecibos() {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(ibillsNegocio.getMyRecibos())
                        .build()
        );
    }

}
