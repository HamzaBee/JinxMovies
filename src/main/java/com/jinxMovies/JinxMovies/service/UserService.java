package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User>getUserByUsername(String username);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    boolean emailExists(String email);
    User resetPassword(String token, String newPassword);
    User updateProfile(Long id, User updatedUser);
    void deleteUser(Long id);
    Optional<User> verifyEmailToken(String token);

}
