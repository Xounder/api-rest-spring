package me.dev.api.services;

import java.util.List;

import me.dev.api.model.User;

public interface UserServices {
    User create(User user);
    User findById(Long id);
    void deleteById(Long id);
    List<User> findAll();
}
