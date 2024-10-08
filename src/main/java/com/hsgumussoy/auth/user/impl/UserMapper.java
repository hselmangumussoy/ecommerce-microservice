package com.hsgumussoy.auth.user.impl;

import com.hsgumussoy.auth.user.api.UserDto;

public class UserMapper {
    public static User toEntity(User user, UserDto dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setSurname(dto.getSurName());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .surName(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }
}
