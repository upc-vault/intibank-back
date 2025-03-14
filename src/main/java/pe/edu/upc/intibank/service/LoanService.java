package pe.edu.upc.intibank.service;

import pe.edu.upc.intibank.model.loan.LoanRequestModel;
import pe.edu.upc.intibank.model.loan.LoanResponseModel;

import java.util.List;

public interface LoanService {
    List<LoanResponseModel> all();

    LoanResponseModel register(LoanResponseModel request);

    LoanResponseModel simulation(LoanRequestModel request);
}
