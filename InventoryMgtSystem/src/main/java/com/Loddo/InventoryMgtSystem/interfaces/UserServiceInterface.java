package com.Loddo.InventoryMgtSystem.interfaces;


import com.Loddo.InventoryMgtSystem.dtos.LoginRequest;
import com.Loddo.InventoryMgtSystem.dtos.RegisterRequest;
import com.Loddo.InventoryMgtSystem.dtos.UserDto;
import com.Loddo.InventoryMgtSystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    User registerUser(RegisterRequest registerRequest);

    Optional<User> findByEmail(String email);

    List<UserDto> getUsersByRole(UserDto.Role role);

    User getCurrentLoggedInUser();

    User getUserById(String id);

    User updateUser(String id, UserDto userDto);

    void deleteUser(String id);
}
