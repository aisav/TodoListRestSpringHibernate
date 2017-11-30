CREATE DATABASE todo_list;
USE todo_list;




/*  We can create only the database,,,,,, after runing the programm the table will be created automatically */




CREATE TABLE todo(
      id INT (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      priority INT (11) NOT NULL,
      status ENUM('COMPLETED','IN PROGRESS','CLOSED','NEW') NOT NULL DEFAULT 'NEW'
);
