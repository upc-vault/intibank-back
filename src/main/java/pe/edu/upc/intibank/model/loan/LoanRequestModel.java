package pe.edu.upc.intibank.model.loan;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequestModel {
    @NotNull(message = "Amount loan is required")
    private Double amount_loan;

    @NotNull(message = "Interest rate is required")
    private Double interest_rate;

    @NotNull(message = "Months is required")
    private Integer months;
}
