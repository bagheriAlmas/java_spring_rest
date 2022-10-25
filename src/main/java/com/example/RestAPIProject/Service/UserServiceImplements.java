package com.example.RestAPIProject.Service;

import com.example.RestAPIProject.Model.User;
import com.example.RestAPIProject.Model.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    UserRepository userRepo;

    public UserServiceImplements(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public String createUser(User user) {
        userRepo.save(user);
        return "USER CREATE SUCCESSFUL";
    }

    @Override
    public String updateUser(User user) {
        userRepo.save(user);
        return "USER UPDATE SUCCESSFUL";
    }

    @Override
    public String deleteUser(int userId) {
        userRepo.deleteById(userId);
        return "USER DELETE SUCCESSFUL";
    }

    @Override
    public User getUserByID(int userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
