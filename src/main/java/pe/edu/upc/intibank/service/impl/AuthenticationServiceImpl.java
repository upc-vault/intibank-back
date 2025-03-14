package pe.edu.upc.intibank.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.mapper.UserMapper;
import pe.edu.upc.intibank.model.authentication.AuthenticationResponseModel;
import pe.edu.upc.intibank.model.authentication.LoginRequestModel;
import pe.edu.upc.intibank.model.authentication.RegisterRequestModel;
import pe.edu.upc.intibank.repository.UserRepository;
import pe.edu.upc.intibank.security.JwtService;
import pe.edu.upc.intibank.service.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponseModel register(RegisterRequestModel request) {
        if (isEmailOrPhoneAlreadyExists(request.getEmail(), request.getPhone())) {
            throw new EntityExistsException("Email or Phone Number is already exists");
        }

        User user = userRepository.save(userMapper.toUser(request));

        return AuthenticationResponseModel.builder().token(jwtService.generateToken(user)).build();
    }

    @Override
    public AuthenticationResponseModel login(LoginRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User " + request.getEmail() + " Not Found"));

        return AuthenticationResponseModel
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    private boolean isEmailOrPhoneAlreadyExists(String email, String phone) {
        return userRepository.existsByEmail(email) || userRepository.existsByPhone(phone);
    }
}
