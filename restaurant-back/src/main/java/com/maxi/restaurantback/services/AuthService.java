package com.maxi.restaurantback.services;

import com.maxi.restaurantback.dtos.SignupRequest;
import com.maxi.restaurantback.dtos.UserDTO;
import com.maxi.restaurantback.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthService {


    UserDTO createUser(SignupRequest signupRequest);
}
