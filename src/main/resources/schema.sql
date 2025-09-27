CREATE TABLE users
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    address       VARCHAR(255),
    city          VARCHAR(100),
    state         VARCHAR(100),
    country       VARCHAR(100),
    postal_code   VARCHAR(20),
    phone         VARCHAR(20),
    date_of_birth DATE,
    created_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status        VARCHAR(20) DEFAULT 'ACTIVE',
    last_login    TIMESTAMP
);
