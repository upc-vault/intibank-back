package pe.edu.upc.intibank.mapper;

import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.model.authentication.RegisterRequestModel;

public interface UserMapper {
    User toUser(RegisterRequestModel request);
}
