 create table author(
     id serial primary key,
     first_name varchar(255),
     last_name varchar(255)
 );

 create table book(
     id serial primary key,
     name varchar(255)
 );

 create table library(
     id serial primary key,
     address varchar(255),
     book_id int references book(id),
     author_id int references author(id)
 );

insert into author(first_name, last_name) values ('Abdulmanap', 'Nurmagomedov');
insert into author(first_name, last_name) values ('Igor', 'Rybakov');

insert into book(name) values ('ОТЕЦ');

insert into library(address, book_id, author_id) values ('Gagarenskiy pereulok dom 3', 1, 1);
insert into library(address, book_id, author_id) values ('Gagarenskiy pereulok dom 3', 1, 2);