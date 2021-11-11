package Controllers;

import Repositories.UserRepository;
import models.User;

public class UserController {
    UserRepository userRepo = new UserRepository();

    public User login(String code, String password){
        userRepo.verifyPassword(code, password);

        return userRepo.find(code);
    }

    public boolean logout(User user){
        return false;
    }
}
