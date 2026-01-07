package com.Loddo.InventoryMgtSystem.service;

import com.Loddo.InventoryMgtSystem.dtos.LoginRequest;
import com.Loddo.InventoryMgtSystem.dtos.RegisterRequest;
import com.Loddo.InventoryMgtSystem.dtos.UserDto;
import com.Loddo.InventoryMgtSystem.interfaces.UserServiceInterface;
import com.Loddo.InventoryMgtSystem.model.User;
import com.Loddo.InventoryMgtSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setPhoneNumber(registerRequest.getPhoneNumber());

        // Default first user as ADMIN, others as STAFF
        user.setRole(userRepository.count() == 0 ? "ADMIN" : "STAFF");

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public User getCurrentLoggedInUser() {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User updateUser(String id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }


}
