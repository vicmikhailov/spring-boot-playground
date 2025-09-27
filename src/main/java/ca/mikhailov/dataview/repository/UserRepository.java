package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);
}
