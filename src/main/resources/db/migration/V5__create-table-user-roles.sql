CREATE TABLE user_roles (
    user_id TEXT REFERENCES users(id),
    role TEXT NOT NULL
);