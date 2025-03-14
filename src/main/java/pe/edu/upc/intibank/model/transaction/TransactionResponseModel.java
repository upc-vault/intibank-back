package pe.edu.upc.intibank.model.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseModel {
    private Long id;
    private Double amount;
    private Double balance;
    
}