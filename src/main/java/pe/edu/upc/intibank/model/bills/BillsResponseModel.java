package pe.edu.upc.intibank.model.bills;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillsResponseModel {
    private String estadoPago;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private BigDecimal monto;
    private String numeroSuministro;

}
