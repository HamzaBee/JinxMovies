package com.jinxMovies.JinxMovies.controller;

import com.jinxMovies.JinxMovies.entity.User;
import com.jinxMovies.JinxMovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(userService.emailExists(user.getEmail())){
            return ResponseEntity.badRequest().build();
        }
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllusers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User>getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/email/{email")
    public ResponseEntity<User>getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<User>updateProfile(@PathVariable Long id,@RequestBody User user){
        try {
            User updatedUser = userService.updateProfile(id,user);
            return ResponseEntity.ok(updatedUser);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/reset-password")
    public ResponseEntity<User>resetPassword(@RequestParam String token, @RequestParam String newPassword){
        try {
            User user = userService.resetPassword(token,newPassword);
            return ResponseEntity.ok(user);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token){
        Optional<User> verifiedUser = userService.verifyEmailToken(token);
        if (verifiedUser.isPresent()){
            return ResponseEntity.ok("Email has been verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid verification token");
        }
    }
    @GetMapping("/check-email")
    public ResponseEntity<Boolean>checkEmailExists(@RequestParam String email){
        boolean exists = userService.emailExists(email);
        return ResponseEntity.ok(exists);

    }

}
