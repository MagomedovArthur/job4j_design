CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers(first_name, last_name, age, country)
values ('Jon', 'Tomas', 20, 'UK'),
        ('Ivan', 'Ivanov', 20, 'UK'),
        ('Ali', 'Aliev', 23, 'RUS'),
        ('Avraam', 'Ruso', 35, 'USA');

select first_name as name, age as min_age from customers
where age = (select min(age) from customers);


CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id)
values (5, 1), (2, 1), (2, 1), (4, 4);

select * from customers c
where c.id not in (select customer_id from orders);