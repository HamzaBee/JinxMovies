package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User>getUserByUsername(String username);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    boolean emailExists(String email);
    User verifyEmail(String token);
    User resetPassword(String token, String newPassword);
    User updateProfile(Long id, User updatedUser);
    void deleteUser(Long id);





}
