package com.myntra.myntra.Service;

import com.myntra.myntra.Entity.UserEntity;
import com.myntra.myntra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {

        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(int userId) {

        return userRepository.findById(userId);
    }

    public UserEntity createUser(UserEntity user) {

        return userRepository.save(user);
    }

    public UserEntity updateUser(int userId, UserEntity userDetails) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());


        return userRepository.save(user);
    }

    public void deleteUser(int userId) {

        userRepository.deleteById(userId);
    }

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            return user.getPasswordHash().equals(password);
        }
        return false;
    }

    public UserEntity updateUserProfile(int userId, UserEntity userDetails) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            if (userDetails.getFirstName() != null) {
                user.setFirstName(userDetails.getFirstName());
            }
            if (userDetails.getLastName() != null) {
                user.setLastName(userDetails.getLastName());
            }
            if (userDetails.getEmail() != null) {
                user.setEmail(userDetails.getEmail());
            }

            return userRepository.save(user);
        }
        throw new RuntimeException("User not found with id: " + userId);
    }


}