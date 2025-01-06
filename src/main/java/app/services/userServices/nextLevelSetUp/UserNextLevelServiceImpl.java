package app.services.userServices.nextLevelSetUp;

import app.models.Users;
import app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNextLevelServiceImpl implements UserNextLevelService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void setNextLevel(String userName) {
        Users response = usersRepository.findByUserName(userName);
        if(response == null) throw new IllegalArgumentException("User not found");
        response.setCurrentLevel(response.getCurrentLevel() + 1);
        usersRepository.save(response);
    }
}
