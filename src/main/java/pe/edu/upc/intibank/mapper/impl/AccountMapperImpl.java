package pe.edu.upc.intibank.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.mapper.AccountMapper;
import pe.edu.upc.intibank.model.account.AccountResponseModel;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponseModel toResponseModel(Account account) {
        return AccountResponseModel
                .builder()
                .card_number(account.getCardNumber())
                .cvv(account.getCvv())
                .balance(account.getBalance())
                .build();
    }
}