package app.services.userServices.findUser;

import app.dtos.response.UserResponse;
import app.models.Users;
import app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserServiceImpl implements FindUserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public long findUserByUserName(String userName) {
        Users response =  usersRepository.findByUserName(userName);
        if (response == null) throw new IllegalArgumentException("User not found");
        return response.getCurrentLevel();
    }
}
