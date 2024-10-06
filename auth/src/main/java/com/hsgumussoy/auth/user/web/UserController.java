package com.hsgumussoy.auth.user.web;

import com.hsgumussoy.auth.user.api.UserMapper;
import com.hsgumussoy.auth.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        return UserMapper.toResponse(service.save(UserMapper.toDto(request)));
    }
    @GetMapping("/{id}")
    public UserResponse get(@PathVariable(name = "id") String id) {
        return UserMapper.toResponse(service.get(id));
    }


    @GetMapping
    public List<UserResponse> getAll() {
        return UserMapper.toResponses(service.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable(name = "id") String id, @RequestBody UserRequest request) {
        return UserMapper.toResponse(service.update(id, UserMapper.toDto(request)));
    }
}
