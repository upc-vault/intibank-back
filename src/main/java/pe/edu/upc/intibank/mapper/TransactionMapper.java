package pe.edu.upc.intibank.mapper;

import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.Transaction;
import pe.edu.upc.intibank.entity.TransactionType;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;

public interface TransactionMapper {
    Transaction toEntity(double amount, Account account, TransactionType type);
    TransactionResponseModel toResponseModel(Long id, double amount, double balance);
}
