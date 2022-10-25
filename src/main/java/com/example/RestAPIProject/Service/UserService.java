package com.example.RestAPIProject.Service;

import com.example.RestAPIProject.Model.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(int userId);
    public User getUserByID(int userId);
    public List<User> getAllUsers();
}
