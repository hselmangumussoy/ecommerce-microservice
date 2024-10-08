package com.hsgumussoy.auth.user.impl;

import com.hsgumussoy.auth.user.api.UserDto;
import com.hsgumussoy.auth.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public UserDto save(UserDto dto) {
        return UserMapper.toDto(repository.save(UserMapper.toEntity(new User(),dto)));
    }

    @Override
    public UserDto get(String id) {
        User user = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException( "User not fund with" + id));

        return UserMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public UserDto update(String id, UserDto dto) {
        return null;
    }
}
