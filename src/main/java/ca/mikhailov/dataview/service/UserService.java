package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);
}
