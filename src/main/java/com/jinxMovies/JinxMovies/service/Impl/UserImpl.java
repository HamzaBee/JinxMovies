package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.entity.User;
import com.jinxMovies.JinxMovies.repository.UserRepository;
import com.jinxMovies.JinxMovies.service.UserService;

import java.util.Optional;

public class UserImpl implements UserService {

    private final UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User verifyEmail(String token) {
        return userRepository.findByVerificationToken(token);
    }

    @Override
    public User resetPassword(String token, String newPassword) {
        return null;
    }

    @Override
    public User updateProfile(Long id, User updatedUser) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
