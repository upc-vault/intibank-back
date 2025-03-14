package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.model.transaction.DepositRequestModel;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;
import pe.edu.upc.intibank.model.transaction.WithdrawRequestModel;
import pe.edu.upc.intibank.model.transaction.TransferRequestModel;

public interface TransactionService {
    TransactionResponseModel deposit(DepositRequestModel request);
    TransactionResponseModel withdraw(WithdrawRequestModel request);
    TransactionResponseModel transfer(TransferRequestModel request); // Nuevo método agregado
}