DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS articles;

CREATE TABLE users
(
    id  BIGINT PRIMARY KEY auto_increment,
    login VARCHAR(128),
    firstname VARCHAR(256),
    lastname VARCHAR(256),
    description VARCHAR(256),
);

CREATE TABLE articles
(
    id  BIGINT PRIMARY KEY auto_increment,
    title VARCHAR(128),
    headline VARCHAR(256),
    content VARCHAR(256),
    slug VARCHAR(256),
    add_at DATETIME,
    user_id BIGINT UNIQUE REFERENCES users (id)
);
