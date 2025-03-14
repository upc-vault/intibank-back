package pe.edu.upc.intibank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.Transaction;
import pe.edu.upc.intibank.entity.TransactionType;
import pe.edu.upc.intibank.exception.LowBalanceException;
import pe.edu.upc.intibank.mapper.TransactionMapper;
import pe.edu.upc.intibank.model.transaction.DepositRequestModel;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;
import pe.edu.upc.intibank.model.transaction.WithdrawRequestModel;
import pe.edu.upc.intibank.repository.AccountRepository;
import pe.edu.upc.intibank.repository.TransactionRepository;
import pe.edu.upc.intibank.service.TransactionService;
import pe.edu.upc.intibank.model.transaction.TransferRequestModel;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionResponseModel deposit(DepositRequestModel request) {
        Account account = accountRepository
                .findByCardNumber(request.getCard_number())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        Long transactionId = performDeposit(account, request.getAmount());

        return transactionMapper.toResponseModel(transactionId, request.getAmount(), account.getBalance());
    }

    @Override
    public TransactionResponseModel withdraw(WithdrawRequestModel request) {
        Account account = accountRepository
                .findByCardNumberAndCvv(request.getCard_number(), request.getCvv())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        Long transactionId = performWithdrawal(account, request.getAmount());

        return transactionMapper.toResponseModel(transactionId, request.getAmount(), account.getBalance());
    }

    private Long performDeposit(Account account, double amount) {
        updateAccountBalance(account, amount);
        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(amount, account, TransactionType.DEPOSIT));
        return transaction.getId();
    }

    private Long performWithdrawal(Account account, double amount) {
        if (account.getBalance() < amount) {
            throw new LowBalanceException("Your Balance " + account.getBalance() + " is not enough to withdraw " + amount);
        }

        updateAccountBalance(account, -amount);
        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(amount, account, TransactionType.WITHDRAW));
        return transaction.getId();
    }

    private void updateAccountBalance(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Override
    public TransactionResponseModel transfer(TransferRequestModel request) {
        Account fromAccount = accountRepository.findById(request.getFromAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de origen no encontrada"));
        Account toAccount = accountRepository.findById(request.getToAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de destino no encontrada"));

        if (!fromAccount.getUser().getId().equals(toAccount.getUser().getId())) {
            throw new BadCredentialsException("Ambas cuentas deben pertenecer al mismo usuario");
        }

        if (fromAccount.equals(toAccount)) {
            throw new BadCredentialsException("las cuentas deben ser distintas");
        }


        if (fromAccount.getBalance() < request.getAmount()) {
            throw new LowBalanceException("Saldo insuficiente en la cuenta de origen");
        }

        // Realizar la transferencia
        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());

        // Guardar cambios en la base de datos
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Registrar la transacción con timestamp
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setNotes("Transferencia entre cuentas");
        transaction.setType(TransactionType.TRANSFER);
        transaction.setAccount(fromAccount);
        transaction.setTimestamp(LocalDate.now()); // 🔹 Se asigna la fecha y hora actual

        transactionRepository.save(transaction);

        return TransactionMapper.toResponse(transaction);

    }

}