package com.example.userlocation;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<UserLocation> createUser(@RequestBody UserLocation userLocation) {
        UserLocation createdUser = userService.createUser(userLocation);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    
    @PutMapping("/{userId}")
    public UserLocation updateUser(@PathVariable Long userId, @RequestBody UserLocation userLocation) {
        return userService.updateUser(userId, userLocation);
    }
    
    @GetMapping("/nearest/{n}")
    public List<UserLocation> getNearestUsers(@PathVariable int n) {
        return userService.getNearestUsers(n);
    }
}

