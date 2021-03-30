DROP TABLE IF EXISTS profiles;

CREATE TABLE profiles (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              first_name VARCHAR(250) NOT NULL,
                              last_name VARCHAR(250) NOT NULL,
                              job_status VARCHAR(250) DEFAULT NULL
);


INSERT INTO profiles (first_name, last_name, job_status) VALUES
('Lokesh', 'Gupta', 'ACTIVE'),
('Deja', 'Vu', 'INACTIVE'),
('Caption', 'America', 'ACTIVE');