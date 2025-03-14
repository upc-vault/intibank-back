package pe.edu.upc.intibank.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.intibank.entity.Transaction;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.model.transaction.DepositRequestModel;
import pe.edu.upc.intibank.model.transaction.WithdrawRequestModel;
import pe.edu.upc.intibank.service.TransactionService;
import pe.edu.upc.intibank.model.transaction.TransactionResponseModel;
import pe.edu.upc.intibank.model.transaction.TransferRequestModel;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<ResponseModel> deposit(@Valid @RequestBody DepositRequestModel request) {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(transactionService.deposit(request))
                        .build()
        );
    }

    @PostMapping("/withdraw")
    public ResponseEntity<ResponseModel> withdraw(@Valid @RequestBody WithdrawRequestModel request) {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(transactionService.withdraw(request))
                        .build()
        );
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponseModel> transfer(@RequestBody TransferRequestModel request) {
        return ResponseEntity.ok(transactionService.transfer(request));
    }
}