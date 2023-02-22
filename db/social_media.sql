create table person(
    id serial primary key,
    "name" text
);

create table messengers(
    id serial primary key,
    "name" text,
    person_id int references person(id)
);

insert into person("name") values ('Artur');
insert into messengers("name", person_id) values ('WhatsApp', 1);
insert into messengers("name", person_id) values ('Telegram', 1);
insert into messengers("name", person_id) values ('Viber', 1);

select p.name, m.name
from person as p join messengers as m on p.id = m.person_id;

select p.name as "Имя юзера", m.name as "Имя мессенджера"
from person as p join messengers as m on p.id = m.person_id;

select p.name Пользователь, m.name "Социальные сети"
from person p join messengers m on p.id = m.person_id;