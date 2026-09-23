DROP TABLE IF EXISTS users;

CREATE TABLE users (
id SERIAL PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO users (full_name, email)
VALUES
('Nguyen Minh Nhi', 'nmnhi@tma.com.vn'),
('Nguyen Minh A', 'a@gmail.com.vn'),
('Nguyen Minh B', 'b@gmail.com.vn'),
('Nguyen Van C', 'c@gmail.com'),
('Nguyen Van D', 'd@gmail.com'),
('Tran Van E', 'e@gmail.com'),
('Le Thi F', 'f@gmail.com'),
('Pham Van G', 'g@gmail.com');