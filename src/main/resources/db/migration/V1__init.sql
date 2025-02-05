CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pets (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      species VARCHAR(50) NOT NULL,
                      breed VARCHAR(50),
                      age INTEGER,
                      ownerd_name VARCHAR(100),
                      user_id INTEGER NOT NULL,
                      FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE vital_signs (
                             id SERIAL PRIMARY KEY,
                             temperature DECIMAL(4,2),
                             heart_rate INTEGER,
                             date DATE NOT NULL,
                             time TIME NOT NULL,
                             device VARCHAR(100),
                             pet_id INTEGER NOT NULL,
                             FOREIGN KEY (pet_id) REFERENCES pets(id)
);

