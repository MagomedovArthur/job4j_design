create table users(
    id serial primary key,
    field text,
    role_id int references role(id)
);

create table role(
    id serial primary key,
    field text
);

create table rules(
    id serial primary key,
    field text
);

create table role_rules(
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);

create table item(
    id serial primary key,
    field text,
    users_id int references users(id),
    comments_id int references comments(id),
    attachs_id int references attachs(id)
);

create table comments(
    id serial primary key,
    field text
);

create table attachs(
    id serial primary key,
    field text
);

create table category(
    id serial primary key,
    field text,
    item_id int references item(id)
);

create table state(
    id serial primary key,
    field text,
    item_id int references item(id)
);

select * from users;