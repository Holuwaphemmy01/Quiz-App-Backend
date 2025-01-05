package app.services.userServices.findUserCurrentLevel;

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
        System.out.println("jssjsjsj");
        long response =  usersRepository.findCurrentLevelByUserName(userName);
        System.out.println(response+"1");
        return response;
    }
}
