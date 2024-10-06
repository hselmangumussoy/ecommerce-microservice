package com.hsgumussoy.auth.user.api;

import java.util.List;

public interface UserService {
    UserDto save(UserDto dto);

    UserDto get(String id);

    List<UserDto> getAll();

    void delete(String id);

    UserDto update(String id, UserDto dto);
}
