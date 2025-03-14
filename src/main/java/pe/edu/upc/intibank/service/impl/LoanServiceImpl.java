package pe.edu.upc.intibank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.Loan;
import pe.edu.upc.intibank.model.loan.LoanRequestModel;
import pe.edu.upc.intibank.model.loan.LoanResponseModel;
import pe.edu.upc.intibank.repository.LoanRepository;
import pe.edu.upc.intibank.service.LoanService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public List<LoanResponseModel> all() {
        List<Loan> loans = loanRepository.findAll();
        return loanRepository.findAll().stream().map(loan -> {

            Double monthlyPayment = calculateMonthlyPayment(loan.getAmount_loan(), loan.getMonths(), loan.getInterest_rate());

            LocalDate startLocalDate = loan.getDate_loan_start().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate endLocalDate = startLocalDate.plusMonths(loan.getMonths());
            Date loanEndDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


            LoanResponseModel response = new LoanResponseModel();
            response.setId(loan.getId());
            response.setDni(loan.getDni());
            response.setAmount_loan(loan.getAmount_loan());
            response.setInterest_rate(loan.getInterest_rate());
            response.setMonths(loan.getMonths());
            response.setDate_loan_start(loan.getDate_loan_start());
            response.setDate_loan_end(loanEndDate);
            response.setMonthly_payment(monthlyPayment);
            return response;
        }).toList();
    }

    @Override
    public LoanResponseModel register(LoanResponseModel request) {
        Loan loan = Loan.builder()
                .dni(request.getDni())
                .amount_loan(request.getAmount_loan())
                .interest_rate(request.getInterest_rate())
                .months(request.getMonths())
                .date_loan_start(new Date())
                .build();

        loan = loanRepository.save(loan);

        Double monthlyPayment = calculateMonthlyPayment(loan.getAmount_loan(), loan.getMonths(), loan.getInterest_rate());

        LocalDate startLocalDate = loan.getDate_loan_start().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate endLocalDate = startLocalDate.plusMonths(loan.getMonths());
        Date loanEndDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return LoanResponseModel.builder()
                .id(loan.getId())
                .dni(loan.getDni())
                .amount_loan(loan.getAmount_loan())
                .interest_rate(loan.getInterest_rate())
                .months(loan.getMonths())
                .date_loan_start(loan.getDate_loan_start())
                .date_loan_end(loanEndDate)
                .monthly_payment(monthlyPayment)
                .build();
    }

    @Override
    public LoanResponseModel simulation(LoanRequestModel request) {
        Double amountLoan = request.getAmount_loan();
        Integer months = request.getMonths();
        Double interestRate = (months <= 36) ? 14.0 : 12.0;

        Date loanStartDate = new Date();

//        Loan loan = Loan.builder()
//                .amount_loan(amountLoan)
//                .months(months)
//                .interest_rate(interestRate)
//                .date_loan_start(loanStartDate)
//                .build();

        Double monthlyPayment = calculateMonthlyPayment(amountLoan, months, interestRate);

        LocalDate startLocalDate = loanStartDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate endLocalDate = startLocalDate.plusMonths(months);
        Date loanEndDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        LoanResponseModel response = new LoanResponseModel();
        response.setAmount_loan(amountLoan);
        response.setMonths(months);
        response.setInterest_rate(interestRate);
        response.setDate_loan_start(loanStartDate);
        response.setDate_loan_end(loanEndDate);
        response.setMonthly_payment(monthlyPayment);

        return response;
    }

    private double calculateMonthlyPayment(Double amount, Integer months, Double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;

        if (monthlyInterestRate == 0) {
            return amount / months;
        }

        double monthlyPayment = (monthlyInterestRate * amount) /
                (1 - Math.pow(1 + monthlyInterestRate, -months));

        return Math.round(monthlyPayment * 100.0) / 100.0;
    }
}