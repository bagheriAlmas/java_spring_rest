package com.example.RestAPIProject.Controller;

import com.example.RestAPIProject.Model.User;
import com.example.RestAPIProject.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User getUserByID(@PathVariable("userId")int id){
        logger.info("USER " + id + " GET");
        return userService.getUserByID(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        logger.info("GET ALL USERS");
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        logger.info("USER " + user.getFirstName() + " " + user.getLastName() + " HAS CREATED");
        return "USER CREATE SUCCESSFUL";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        logger.info("USER " + user.getFirstName() + " " + user.getLastName() + " HAS UPDATED");
        return "USER UPDATE SUCCESSFUL";
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        logger.info("USER " + userId + " HAS DELETED");
        return "USER DELETE SUCCESSFUL";
    }
}
