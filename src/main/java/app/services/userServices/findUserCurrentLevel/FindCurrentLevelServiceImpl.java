package app.services.userServices.findUserCurrentLevel;

import app.models.Users;
import app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCurrentLevelServiceImpl implements FindCurrentLevelService {
    @Autowired
   private UsersRepository usersRepository;

    @Override
    public long getCurrentLevel(String userName) {
        boolean userExist = usersRepository.existsByUserName(userName);
        if (!userExist) throw new IllegalArgumentException("User does not exist");
        Users response = usersRepository.findByUserName(userName);
        if (response == null) throw new IllegalArgumentException("User does not exist");
        return response.getCurrentLevel();
    }
}
