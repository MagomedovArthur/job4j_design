create table fauna
(
    id serial primary key,
    "name" text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('lion', 10, '05-05-1758');
insert into fauna(name, avg_age, discovery_date)
values ('lioness', 15, '04-12-1758');
insert into fauna(name, avg_age, discovery_date)
values ('giraffe', 35, '12-02-1758');
insert into fauna(name, avg_age, discovery_date)
values ('elephant', 60, '22-12-1600');
insert into fauna(name, avg_age, discovery_date)
values ('zebra', 30, '12-07-1783');
insert into fauna(name, avg_age, discovery_date)
values ('mammoth', null, null);

select * from fauna where name like '%lion%';
select * from fauna where avg_age > 15 and avg_age < 40;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01-01-1950';


