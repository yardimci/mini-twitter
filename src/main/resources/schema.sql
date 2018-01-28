DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS followers;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;

-- Feel free to augment or modify these schemas (and the corresponding data) as you see fit!
CREATE TABLE users (
    id IDENTITY,
    username VARCHAR UNIQUE,
    password VARCHAR,
    name VARCHAR,

);

CREATE TABLE user_roles(
    username VARCHAR,
    role VARCHAR
);

CREATE TABLE messages (
    id IDENTITY,
    person_id NUMBER REFERENCES users (id),
    content VARCHAR,
    PRIMARY KEY (id),

);

CREATE TABLE followers (
    id IDENTITY,
    person_id NUMBER REFERENCES users (id),
    follower_person_id NUMBER REFERENCES users (id)
);
