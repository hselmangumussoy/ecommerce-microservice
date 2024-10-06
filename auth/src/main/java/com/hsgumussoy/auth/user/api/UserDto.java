package com.hsgumussoy.auth.user.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;
}
