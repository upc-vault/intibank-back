package pe.edu.upc.intibank.mapper;

import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.model.account.AccountResponseModel;

public interface AccountMapper {
    AccountResponseModel toResponseModel(Account account);
}
