package com.maxi.restaurantback.controllers;

import com.maxi.restaurantback.dtos.SignupRequest;
import com.maxi.restaurantback.dtos.UserDTO;
import com.maxi.restaurantback.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        UserDTO user = authService.createUser(signupRequest);
        if(user == null){
            return  new ResponseEntity<>("Sorry, the new user was not created. Try again later!", HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok().body("New user: [User name: "+user.getName()+" and Email: "+user.getEmail()+"] was created successfully.");
    }
}
