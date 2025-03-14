package pe.edu.upc.intibank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.intibank.entity.Bills;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.service.IBillsNegocio;

import java.util.List;

@RestController
@RequestMapping("/intibank/pagos")
public class PagoReciboServicioRest {

    //  PAGO DE SERVICIOS DE LUZ, AGUA, INTERNET
    //  PAGO DE SERVICIOS DE TELEFONÍA MOVIL (CLARO, MOVISTAR, ENTEL, BITEL)

    //  EL PARAMETRO SUMINISTRO ES EL NUMERO DE SUMINISTRO DE LOS RECIBOS DE LUZ, AGUA, INTERNET Y TAMBIÉN ES EL NÚMERO DE TELÉFONO

    @Autowired
    private IBillsNegocio billsNegocio;

    @GetMapping("/recibos/{sumi}") //http://localhost:8090/intibank/pagos/recibos/{suministro}
    public List<Bills> buscarBillsPorSuministro(@PathVariable(value = "sumi") String sumi) {
        return billsNegocio.listarBillsPorSuministro(sumi);
    }

                //POST PAGAR SERVICIO DE LUZ AGUA, INTERNET


    //  PAGO DE TARJETA DE CREDITO

    @GetMapping
    public ResponseEntity<ResponseModel> getMyRecibos() {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(billsNegocio.getMyRecibos())
                        .build()
        );
    }

}
