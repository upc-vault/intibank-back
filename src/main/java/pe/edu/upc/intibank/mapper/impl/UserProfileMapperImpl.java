package pe.edu.upc.intibank.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.upc.intibank.entity.User;
import pe.edu.upc.intibank.mapper.UserProfileMapper;
import pe.edu.upc.intibank.model.authentication.UserProfileResponseModel;

@Component
public class UserProfileMapperImpl implements UserProfileMapper {
    @Override
    public UserProfileResponseModel toUserProfile(User user) {
        return UserProfileResponseModel
                .builder()
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
