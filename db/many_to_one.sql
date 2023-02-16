create table region(
  id serial primary key,
  name varchar(255)
);

create table ethnic_group(
  id serial primary key,
  name varchar(255)
  region_id int references region(id)
);

insert into region(name) values ('Dagestan');
insert into ethnic_group(name, region_id) values ('Lezgins', 1);
insert into ethnic_group(name, region_id) values ('Avars', 1);
insert into ethnic_group(name, region_id) values ('Dargins', 1);
insert into ethnic_group(name, region_id) values ('Aguls', 1);