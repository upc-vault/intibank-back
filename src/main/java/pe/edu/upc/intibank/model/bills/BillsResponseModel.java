package pe.edu.upc.intibank.model.bills;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillsResponseModel {
    private String estadoPago;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private Double monto;
    private String numeroSuministro;

}
