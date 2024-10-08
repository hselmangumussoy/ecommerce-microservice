package com.hsgumussoy.auth.user.api;

import com.hsgumussoy.auth.user.web.UserRequest;
import com.hsgumussoy.auth.user.web.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toDto(UserRequest request) {
        return UserDto.builder()
                .email(request.getMail())
                .password(request.getPassword())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .surName(request.getSurname())
                .build();
    }

    public static UserResponse toResponse(UserDto dto) {
        return UserResponse.builder()
                .id(dto.getId())
                .mail(dto.getEmail())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .surname(dto.getSurName())
                .password(dto.getPassword())
                .build();
    }
    public static List<UserResponse> toResponses(List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

}
