package pe.edu.upc.intibank.model.transaction;

import lombok.Data;
@Data
public class TransferRequestModel {
    private Long fromAccountId;
    private Long toAccountId;
    private double amount;
}
