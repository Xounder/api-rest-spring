package me.dev.api.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dev.api.model.User;
import me.dev.api.repository.UserRepository;
import me.dev.api.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if (userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("The User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(this.findById(id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
}
