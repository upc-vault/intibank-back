package pe.edu.upc.intibank.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.model.account.AccountResponseModel;
import pe.edu.upc.intibank.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<ResponseModel> createNewAccount() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseModel
                        .builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .data(accountService.createNewAccount())
                        .build()
                );
    }

    @GetMapping
    public ResponseEntity<ResponseModel> getMyAccounts() {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(accountService.getMyAccounts())
                        .build()
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseModel> getAccountsByUserId(@PathVariable Long userId) {
        try {
            List<AccountResponseModel> accounts = accountService.getAccountsByUserId(userId);
            return ResponseEntity.ok(
                    ResponseModel.builder()
                            .status(HttpStatus.OK)
                            .success(true)
                            .data(accounts) // No necesitamos especificar el tipo genérico aquí
                            .build()
            );
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseModel.builder()
                            .status(HttpStatus.NOT_FOUND)
                            .success(false)
                            .message(e.getMessage())
                            .build()
            );
        }
    }

}