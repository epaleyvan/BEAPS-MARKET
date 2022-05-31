CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
CREATE DATABASE bdbeapsmarket CHARACTER SET 'utf8mb4';
GRANT ALL PRIVILEGES ON bdbeapsmarket.* TO 'admin'@'localhost';