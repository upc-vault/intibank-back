package pe.edu.upc.intibank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.service.AccountService;

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
}