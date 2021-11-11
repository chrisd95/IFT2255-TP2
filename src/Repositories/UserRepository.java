package Repositories;

import models.User;

import java.util.ArrayList;

public class UserRepository implements CrudRepository<User, String> {
    ArrayList<User> list = new ArrayList<>();

    @Override
    public User find(String id) {
        return null;
    }

    @Override
    public ArrayList<User> findAll() {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public boolean verifyPassword(String code, String p){
        User userFound = this.find(p);
        if(true){
            return true;
        }
        return false;
    }

}
