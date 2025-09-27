package ca.mikhailov.dataview.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record User(
        Long id,
        String name,
        String email,
        String password,
        String address,
        String city,
        String state,
        String country,
        String postalCode,
        String phone,
        LocalDate dateOfBirth,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String status,
        LocalDateTime lastLogin
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String address;
        private String city;
        private String state;
        private String country;
        private String postalCode;
        private String phone;
        private LocalDate dateOfBirth;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String status;
        private LocalDateTime lastLogin;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder lastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public User build() {
            return new User(
                    id,
                    name,
                    email,
                    password,
                    address,
                    city,
                    state,
                    country,
                    postalCode,
                    phone,
                    dateOfBirth,
                    createdAt,
                    updatedAt,
                    status,
                    lastLogin
            );
        }
    }
}
