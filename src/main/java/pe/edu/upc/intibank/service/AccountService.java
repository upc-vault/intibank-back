package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.model.account.AccountResponseModel;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    AccountResponseModel createNewAccount();

    List<AccountResponseModel> getMyAccounts();

    Optional<Account> findById(Long id);

    Account save(Account account);
}
