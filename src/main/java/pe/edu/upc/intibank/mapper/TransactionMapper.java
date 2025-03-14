package pe.edu.upc.intibank.mapper;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.Transaction;
import pe.edu.upc.intibank.entity.TransactionType;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;

public interface TransactionMapper {

    //static TransactionResponseModel toResponse(Transaction transaction) { return transaction;}

    Transaction toEntity(double amount, Account account, TransactionType type);
    TransactionResponseModel toResponseModel(Long id, double amount, double balance);

    static TransactionResponseModel toResponse(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        TransactionResponseModel transactionResponseModel = new TransactionResponseModel();
        transactionResponseModel.setId(transaction.getId());
        transactionResponseModel.setAmount(transaction.getAmount());



        return transactionResponseModel;


    }
}
