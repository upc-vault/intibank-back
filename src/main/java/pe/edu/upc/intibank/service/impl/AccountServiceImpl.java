package pe.edu.upc.intibank.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.ServiceType;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.mapper.AccountMapper;
import pe.edu.upc.intibank.model.account.AccountResponseModel;
import pe.edu.upc.intibank.repository.AccountRepository;
import pe.edu.upc.intibank.repository.UserRepository;
import pe.edu.upc.intibank.service.AccountService;
import pe.edu.upc.intibank.utils.Utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponseModel createNewAccount() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        Account account = accountRepository.save(
            Account
                .builder()
                .cardNumber(generateUniqueCardNumber())
                .cvv(Utils.generateCVV())
                .balance(0.0)
                .user(user)
                .build()
        );

        return accountMapper.toResponseModel(account);
    }

    @Override
    public List<AccountResponseModel> getMyAccounts() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return accountRepository
                .findAllByUser(user)
                .stream()
                .map(accountMapper::toResponseModel)
                .toList();
    }

    public String generateUniqueCardNumber() {
        String cardNumber = Utils.generateCardNumber();

        while (accountRepository.existsByCardNumber(cardNumber)) {
            cardNumber = Utils.generateCardNumber();
        }

        return cardNumber;
    }


    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }


    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}