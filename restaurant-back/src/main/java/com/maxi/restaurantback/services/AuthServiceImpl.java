package com.maxi.restaurantback.services;

import com.maxi.restaurantback.configurations.WebSecurityConfiguration;
import com.maxi.restaurantback.dtos.SignupRequest;
import com.maxi.restaurantback.dtos.UserDTO;
import com.maxi.restaurantback.entities.User;
import com.maxi.restaurantback.enums.UserRole;
import com.maxi.restaurantback.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);

        User newUserCreate = userRepository.save(user);

        UserDTO newUserCreateDTO = new UserDTO();
        newUserCreateDTO.setId(newUserCreate.getId());
        newUserCreateDTO.setName(newUserCreate.getName());
        newUserCreateDTO.setEmail(newUserCreate.getEmail());
        newUserCreateDTO.setPassword(newUserCreateDTO.getPassword());
        newUserCreateDTO.setUserRole(newUserCreate.getUserRole());
        return newUserCreateDTO;
    }
}
