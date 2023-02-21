create table "user"(
    id serial primary key,
    "name" text
);

create table messengers(
    id serial primary key,
    "name" text,
    user_id int references "user"(id)
);

insert into "user"("name") values ('Artur');
insert into messengers("name", user_id) values ('WhatsApp', 1);
insert into messengers("name", user_id) values ('Telegram', 1);
insert into messengers("name", user_id) values ('Viber', 1);

select u.name, m.name
from "user" as u join messengers as m on u.id = m.user_id;

select u.name as "Имя юзера", m.name as "Имя мессенджера"
from "user" as u join messengers as m on u.id = m.user_id;

select u.name "Пользователь", m.name "Социальные сети"
from "user" u join messengers m on u.id = m.user_id;