package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.model.account.AccountResponseModel;

import java.util.List;

public interface AccountService {
    AccountResponseModel createNewAccount();

    List<AccountResponseModel> getMyAccounts();

}
