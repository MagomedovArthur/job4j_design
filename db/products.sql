create table type
(
    id   serial primary key,
    name varchar(255)
);

create table product
(
    id           serial primary key,
    name         varchar(255),
    type_id      int references type (id),
    expired_date date,
    price        int
);

insert into type(name)
values ('Сыр'),
       ('Молоко'),
       ('Мороженое');

insert into product(name, type_id, expired_date, price)
values ('Плавленный сыр', 1, '2023-12-02', 200),
       ('Голландский сыр', 1, '2023-01-02', 400),
       ('Швейцарский сыр', 1, '2023-03-01', 1500),
       ('Сыр с плесенью', 1, '2024-02-02', 2000),
       ('Домик в деревне', 2, '2023-05-05', 212),
       ('Экомилк', 2, '2023-06-05', 199),
       ('Молоко отборное', 2, '2022-12-15', 300),
       ('Молоко топлёное', 2, '2022-11-05', 230),
       ('Кубанская Бурёнка', 2, '2023-04-28', 349),
       ('Магнат', 3, '2023-02-02', 110),
       ('Милка', 3, '2023-04-23', 190),
       ('48 Копеек', 3, '2023-12-09', 500),
       ('Орео', 3, '2022-12-28', 250);

insert into  product(name, type_id, expired_date, price)
values ('Мороженое пломбир', 3, '2023-04-28', 56);

select * from product where type_id = 1;

select * from product where name like '%Мороженое%';

select * from product where expired_date < '2023-02-28';

select t.name, max(p.price)
from product as p
join type as t
on p.type_id = t.id
group by t.name;

select t.name, count(p.type_id)
from product as p
join type as t
on p.type_id = t.id
group by t.name;

select * from product where type_id = 1 or type_id = 2;

select t.name, count(p.type_id)
from type as t
join product as p
on t.id = p.type_id
group by t.name
having count(p.type_id) < 10;

select t.name as "Тип продукта", p.name as "Имя продукта"
from type as t
join product as p
on t.id = p.type_id
group by t.name, p.name;