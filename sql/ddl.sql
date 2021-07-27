create table member(
 id INT NOT NULL AUTO_INCREMENT,
 name varchar(255),
 title varchar(255),
 date datetime DEFAULT CURRENT_TIMESTAMP,
 primary key (id)
);