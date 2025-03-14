package pe.edu.upc.intibank.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.intibank.model.ResponseModel;
import pe.edu.upc.intibank.model.loan.LoanRequestModel;
import pe.edu.upc.intibank.model.loan.LoanResponseModel;
import pe.edu.upc.intibank.service.LoanService;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/all")
    public ResponseEntity<ResponseModel> all() {
        return ResponseEntity.ok(
                ResponseModel.builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(loanService.all())
                        .build()
        );
    }

    @PostMapping("/simulation")
    public ResponseEntity<ResponseModel> simulation(@Valid @RequestBody LoanRequestModel request) {
        return ResponseEntity.ok(
                ResponseModel.builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(loanService.simulation(request))
                        .build()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseModel> register(@Valid @RequestBody LoanResponseModel request) {
        return ResponseEntity.ok(
                ResponseModel.builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .data(loanService.register(request))
                        .build()
        );
    }
}
