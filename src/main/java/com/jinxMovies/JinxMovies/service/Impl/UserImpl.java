package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.entity.User;
import com.jinxMovies.JinxMovies.repository.UserRepository;
import com.jinxMovies.JinxMovies.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
    public User resetPassword(String token, String newPassword) {
        Optional<User> optionalUser = userRepository.findByResetPasswordToken(token);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setHashPassword(newPassword);
            user.setResetPasswordToken(null);
            return userRepository.save(user);
        }
        throw new RuntimeException("Invalid Token");

    }

    @Override
    public User updateProfile(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());
            user.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
            return  userRepository.save(user);
        }
        throw new RuntimeException("User not Found");
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> verifyEmailToken(String token) {
        Optional<User> optionalUser = userRepository.findByVerificationToken(token);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setVerificationToken(null);
            user.setEmailVerified(true);
            userRepository.save(user);

        }
        return optionalUser;
    }


}
