create or replace function tax()
    returns trigger as
$$
BEGIN
    update products
    set price = price + (price * 0.07)
    where id = (select id from inserted);
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 100);

create or replace function discount()
    returns trigger as
$$
BEGIN
    update products
    new.price = new.price + (new.price * 0.10)
    where id = new.id;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

create trigger discount_trigger
    before insert
    on products
    for each row
execute procedure discount();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 100);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create or replace function func()
    returns trigger as
$$
BEGIN
    insert into history_of_price(name, price, date)
    values (new.name, new.price, current_date);
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

create trigger trigger1
    after insert
    on products
    for each row
execute procedure func();

insert into products (name, producer, count, price) VALUES ('product_8', 'producer_6', 23, 1212);

