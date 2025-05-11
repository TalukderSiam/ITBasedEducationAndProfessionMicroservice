package com.edupro.EducationWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.dto.request.Response;
import com.edupro.EducationWeb.entity.User;
import com.edupro.EducationWeb.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    Response response = new Response();

    public Response registerUser(User user) {
        Optional<User> findUser = userRepository.findByEmail(user.getEmail());
        if (findUser.isPresent()) {

            response.setStatus(409);
            response.setMessage("Email address is already registered");

            return response;
        }
        userRepository.save(user);
       

        response.setStatus(201);
        response.setMessage("Register Successfull");

        return response;

    }

    public Response loginUser(String email, String password) {
        Optional<User> findUser = userRepository.findByEmail(email);
        if (!findUser.isPresent()) {

            response.setStatus(100);
            response.setMessage("Email is not found");

            return response;
        }
        User user = findUser.get();
        if (password.equals(user.getPassword())) {
            response.setStatus(200);
            response.setMessage("Login Successfully");
            return response;
        }

        response.setStatus(401);
        response.setMessage("Invalid username or password.");

        return response;

    }
}