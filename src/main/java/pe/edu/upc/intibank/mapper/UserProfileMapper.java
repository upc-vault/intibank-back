package pe.edu.upc.intibank.mapper;

import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.model.authentication.UserProfileResponseModel;

public interface UserProfileMapper {
    UserProfileResponseModel toUserProfile(User user);
}
