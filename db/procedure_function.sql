create or replace procedure p_delete_data(p_id integer)
    language 'plpgsql'
as $$
BEGIN
        delete from products where id = p_id;
END;
$$;

call p_delete_data(4);



insert into products(name, producer, count, price) values ('name1', 'prod1', 0, 100);


create or replace function f_delete_data(f_count integer)
    returns void
    language 'plpgsql'
as
$$
begin
    if f_count = 0 THEN
        delete from products where count = f_count;
    end if;
end;
$$;

select f_delete_data(0);