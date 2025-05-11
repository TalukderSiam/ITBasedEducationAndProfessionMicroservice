package com.edupro.EducationWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.edupro.EducationWeb.dto.request.LoginModel;
import com.edupro.EducationWeb.dto.request.Response;
import com.edupro.EducationWeb.entity.User;
import com.edupro.EducationWeb.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class RegisterAndLoginController {
     @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody User user) {
        // if (!user.getPassword().equals(user.getConfirmPassword())) {
        //     return "Passwords do not match!";
        // }
        
        return userService.registerUser(user); 
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginModel loginModel ) {
       Response response= userService.loginUser(loginModel.getEmail(),loginModel.getPassword());
        return response ;
    }
}
