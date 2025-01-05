package app.services.userServices.findUser;

import app.dtos.response.UserResponse;

public interface FindUserService {
    long findUserByUserName(String userName);
}
