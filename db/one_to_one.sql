create table person(
  id serial primary key,
  first_name varchar(255),
  last_name varchar(255)
);

create table passport(
  id serial primary key,
  series_number int,
  DOB varchar(255),
  passport_id int references person(id)
);

insert into person(first_name, last_name) values ('Artur', 'Magomedov');
insert into passport(series_number, DOB, passport_id) values (959595, '05.05.2000', 1);

insert into person(first_name, last_name) values ('Ali', 'Alimov');
insert into passport(series_number, DOB, passport_id) values (212122, '08.01.1995', 2);




