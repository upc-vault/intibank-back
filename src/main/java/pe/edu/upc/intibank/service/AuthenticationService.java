package pe.edu.upc.intibank.service;


import pe.edu.upc.intibank.model.authentication.AuthenticationResponseModel;
import pe.edu.upc.intibank.model.authentication.LoginRequestModel;
import pe.edu.upc.intibank.model.authentication.RegisterRequestModel;

public interface AuthenticationService {
    AuthenticationResponseModel register(RegisterRequestModel request);

    AuthenticationResponseModel login(LoginRequestModel request);
}
