package com.hsgumussoy.basket.basket.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;
}