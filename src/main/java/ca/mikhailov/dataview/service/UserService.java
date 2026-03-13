package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);

    User getUserById(Long id);
}
