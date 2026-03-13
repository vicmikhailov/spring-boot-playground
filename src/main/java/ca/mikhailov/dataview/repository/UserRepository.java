package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);
}
