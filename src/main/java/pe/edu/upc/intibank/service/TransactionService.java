package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.model.transaction.DepositRequestModel;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;
import pe.edu.upc.intibank.model.transaction.WithdrawRequestModel;

public interface TransactionService {
    TransactionResponseModel deposit(DepositRequestModel request);
    TransactionResponseModel withdraw(WithdrawRequestModel request);
}