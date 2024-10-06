package com.hsgumussoy.auth.user.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private String phoneNumber;
}
