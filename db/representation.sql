create table car_body
(
    id   serial primary key,
    name text
);

create table car_engine
(
    id   serial primary key,
    name text
);

create table car_transmission
(
    id   serial primary key,
    name text
);

create table car_wheel_drive
(
    id   serial primary key,
    name text
);

create table car_color
(
    id   serial primary key,
    name text
);

create table country_of_origin
(
    id   serial primary key,
    name text
);

create table cars
(
    id                   serial primary key,
    brand_model          text,
    body_id              int references car_body (id),
    engine_id            int references car_engine (id),
    transmission_id      int references car_transmission (id),
    wheel_drive_id       int references car_wheel_drive (id),
    color_id             int references car_color (id),
    country_of_origin_id int references country_of_origin (id)
);

insert into car_body(name)
values ('Седан'),
       ('Универсал'),
       ('Лифтбек'),
       ('Хэтчбек'),
       ('Внедорожник'),
       ('Фургон');

insert into car_engine(name)
values ('Дизель'),
       ('Бензин'),
       ('Бензин + ГБО'),
       ('Электро');

insert into car_transmission(name)
values ('Автомат'),
       ('Механика'),
       ('Робот'),
       ('Вариатор');

insert into car_wheel_drive(name)
values ('Передний'),
       ('Задний'),
       ('Полный');

insert into car_color(name)
values ('Белый'),
       ('Коричневый'),
       ('Черный'),
       ('Серый'),
       ('Красный');

insert into country_of_origin(name)
values ('Германия'),
       ('Япония'),
       ('Франция'),
       ('Корея');

insert into cars(brand_model,
                 body_id,
                 engine_id,
                 transmission_id,
                 wheel_drive_id,
                 color_id,
                 country_of_origin_id)
values ('Киа К5', 1, 2, 1, 1, 3, 4),
       ('Volkswagen Tiguan', 5, 2, 3, 3, 1, 1),
       ('Toyota Land Cruiser 200', 5, 1, 1, 3, 4, 2),
       ('Toyota Camry', 1, 2, 1, 1, 2, 2);


create view show_all_cars as
select c.id,
       c.brand_model brand_and_model,
       bc.name       body,
       ce.name       engine,
       ct.name       transmission,
       wd.name       wheel_drive,
       cc.name       color,
       co.name       country_of_origin
from cars c
         left join car_body bc on c.body_id = bc.id
         left join car_engine ce on c.engine_id = ce.id
         left join car_transmission ct on c.transmission_id = ct.id
         left join car_wheel_drive wd on c.wheel_drive_id = wd.id
         left join car_color cc on c.color_id = cc.id
         left join country_of_origin co on c.country_of_origin_id = co.id;

select * from show_all_cars;