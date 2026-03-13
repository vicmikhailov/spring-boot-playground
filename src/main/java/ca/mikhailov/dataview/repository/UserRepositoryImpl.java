package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        long offset = pageable.getOffset();
        int pageSize = pageable.getPageSize();
        List<User> users = jdbcTemplate.query("SELECT * FROM users LIMIT ? OFFSET ?", new UserRowMapper(), pageSize, offset);

        String countSql = "SELECT count(*) FROM users";
        Long total = jdbcTemplate.queryForObject(countSql, Long.class);

        return new PageImpl<>(users, pageable, total != null ? total : 0);
    }

    @Override
    public User findById(Long id) {
        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new UserRowMapper(), id);
        return users.isEmpty() ? null : users.getFirst();
    }

    private static final class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Timestamp createdAtTs = rs.getTimestamp("created_at");
            Timestamp updatedAtTs = rs.getTimestamp("updated_at");
            Timestamp lastLoginTs = rs.getTimestamp("last_login");
            LocalDateTime createdAt = createdAtTs != null ? createdAtTs.toLocalDateTime() : null;
            LocalDateTime updatedAt = updatedAtTs != null ? updatedAtTs.toLocalDateTime() : null;
            LocalDateTime lastLogin = lastLoginTs != null ? lastLoginTs.toLocalDateTime() : null;
            java.sql.Date dob = rs.getDate("date_of_birth");
            LocalDate dateOfBirth = dob != null ? dob.toLocalDate() : null;
            return User.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .address(rs.getString("address"))
                    .city(rs.getString("city"))
                    .state(rs.getString("state"))
                    .country(rs.getString("country"))
                    .postalCode(rs.getString("postal_code"))
                    .phone(rs.getString("phone"))
                    .dateOfBirth(dateOfBirth)
                    .createdAt(createdAt)
                    .updatedAt(updatedAt)
                    .status(rs.getString("status"))
                    .lastLogin(lastLogin)
                    .build();
        }
    }
}
