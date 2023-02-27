create table devices
(
    id serial primary key,
    devices_name varchar(255),
    price  float
);

create table people
(
    id     serial primary key,
    people_name varchar(255)
);

create table devices_people
(
    id serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(devices_name, price)
values ('iPhone 13 Pro MAX', 100900),
       ('MacBook Pro', 200000),
       ('Apple Watch Series 6', 45000);

insert into people(people_name)
values ('Artur'),
       ('Enver'),
       ('Kamran');

insert into devices_people(device_id, people_id)
values (1, 1),
       (1, 3);
insert into devices_people(device_id, people_id)
values (2, 1),
       (2, 2),
       (2, 3);
insert into devices_people(device_id, people_id)
values (3, 2);

select avg(price) from devices;

select dp.people_id, avg(d.price)
from devices_people as dp
join devices as d
on dp.device_id = d.id
group by dp.people_id;

select dp.people_id, avg(d.price)
from devices_people as dp
join devices as d
on dp.device_id = d.id
group by dp.people_id
having avg(d.price) < 150000;