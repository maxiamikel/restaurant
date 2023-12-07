package com.maxi.restaurantback.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private  String name;
    private String email;
    private String password;
}
