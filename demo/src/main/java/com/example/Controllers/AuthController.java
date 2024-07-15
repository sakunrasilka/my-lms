package com.example.Controllers;

import com.example.Models.User;
import com.example.Repositories.UserRepository;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        Long tempID = user.getId();
        String tempPassword = user.getPassword();

        // Find user by username in the database
        Optional<User> checkUser = userRepository.findById(tempID);
        User item = null;
        if(checkUser.isPresent()){
            item = checkUser.get();
        }

        // Check if user exists and passwords match
        if ( item != null && tempPassword.equals(item.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        userService.addUser(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Registration successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
