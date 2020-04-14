CREATE TABLE IF NOT EXISTS User (
    username VARCHAR(16) NOT NULL,
    password VARCHAR(16) NOT NULL,
    email VARCHAR(64) NOT NULL,
    role VARCHAR(16) NOT NULL,
    PRIMARY KEY (username)
);