package com.maxi.restaurantback.dtos;

import com.maxi.restaurantback.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private  Long id;

    private  String name;
    private  String password;
    private  String email;
    private UserRole userRole;
}
