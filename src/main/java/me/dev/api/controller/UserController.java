package me.dev.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dev.api.model.User;
import me.dev.api.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServices userServices;
        
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userServices.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User userCreated = userServices.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userServices.deleteById(id);
    }
}
