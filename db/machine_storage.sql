create table car_bodies
(
    id   serial primary key,
    name text
);

create table car_engines
(
    id   serial primary key,
    name text
);

create table car_transmissions
(
    id   serial primary key,
    name text
);

create table cars
(
    id              serial primary key,
    name            text,
    body_id         int references car_bodies (id),
    engine_id       int references car_engines (id),
    transmission_id int references car_transmissions (id)
);

insert into car_bodies(name)
values ('Седан'),
       ('Универсал'),
       ('Лифтбек'),
       ('Хэтчбек'),
       ('Внедорожник'),
       ('Фургон');

insert into car_engines(name)
values ('Дизель'),
       ('Бензин'),
       ('Бензин + ГБО'),
       ('Электро');

insert into car_transmissions(name)
values ('Автомат'),
       ('Механика'),
       ('Робот'),
       ('Вариатор');

insert into cars(name, body_id, engine_id, transmission_id)
values ('Toyota Camry', 1, 2, 1),
       ('Volkswagen Multiven', 6, 1, 1),
       ('Lexus LX 450d', 5, 1, 1),
       ('Toyota Land Cruiser 200', 5, 1, 1);

insert into cars(name, body_id, engine_id, transmission_id)
values ('Toyota Corolla', null, null, null);

insert into cars(name, body_id, engine_id, transmission_id)
values ('Skoda Octavia', null, 2, null);

select c.id,
       c.name  car_name,
       bc.name body_name,
       ce.name engine_name,
       ct.name transmission_name
from cars c
         left join car_bodies bc on c.body_id = bc.id
         left join car_engines ce on c.engine_id = ce.id
         left join car_transmissions ct on c.transmission_id = ct.id;


select cb.id, cb.name unused_bodies
from car_bodies cb
         left join cars c on cb.id = c.body_id
where c.id is null;

select ce.id, ce.name unused_engines
from car_engines ce
         left join cars c on ce.id = c.engine_id
where c.id is null;

select ct.id, ct.name unused_transmission
from car_transmissions ct
         left join cars c on ct.id = c.transmission_id
where c.id is null;