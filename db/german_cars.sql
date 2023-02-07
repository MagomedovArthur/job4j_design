create table german_cars(
    id serial primary key,
    brand text,
	model text,
	engine numeric,
	availability smallserial,
	price money
);
insert into german_cars(brand, model, engine, availability, price) 
                 values('Volkswagen', 'Tiguan', 2.0, 50, 2000000);
update german_cars set availability = 90;
delete from german_cars;