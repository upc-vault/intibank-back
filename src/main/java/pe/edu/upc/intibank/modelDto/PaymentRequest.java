package pe.edu.upc.intibank.modelDto;

import lombok.Data;

@Data
public class PaymentRequest {

    private String numeroSuministro; // Cambiado a numeroSuministro
    private Long accountId;

}
