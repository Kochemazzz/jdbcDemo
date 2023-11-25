CREATE TABLE phonebook
(
    idphonebook SERIAL PRIMARY KEY,
    lastname    varchar(40),
    phone       numeric
);

INSERT INTO phonebook(lastname, phone)
VALUES ('Ivanov', 777777777);

INSERT INTO phonebook(lastname, phone)
VALUES ('Petrova', 999999999);

SELECT idphonebook, lastname, phone
FROM phonebook;


DROP TABLE IF EXISTS company;

TRUNCATE TABLE company;



CREATE OR REPLACE PROCEDURE display_msg(INOUT msg TEXT)
AS
$$
BEGIN
    RAISE NOTICE 'Alarm: %', msg;
end;
$$
    LANGUAGE plpgsql;



CREATE OR REPLACE PROCEDURE display_msg(INOUT msg TEXT)
AS
$$
BEGIN
    RAISE NOTICE 'Alarm: %', msg;
end;
$$
    LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE addphonerecords(
    pb_id INOUT INT,
    pb_lastname varchar(40),
    pb_phone numeric
) AS
$$
BEGIN
    UPDATE phonebook
    SET lastname = pb_lastname,
        phone    = pb_phone
    WHERE idphonebook = pb_id;
end;
$$
    LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE findlastname(
    p_phone INT,
    p_lastname varchar(40)
) AS
$$
BEGIN
    SELECT lastname
    INTO p_lastname
    FROM phonebook
    WHERE phone = p_phone;
end;
$$
    LANGUAGE plpgsql;



-- user
-- create table 'user' (...

drop table if exists workers;

create table workers
(
    id          serial primary key, --unique
    --int generated always as identity
    --serial
    first_name  char(25) default 'first_name',
    last_name   character varying(25),

    --varchar()
    middle_name text
);

insert into workers (first_name,
                     last_name,
                     middle_name)
values ('ivan', 'ivanov', 'ivanovich'),
       ('rashida', 'rashidovna', 'rashidova');


select id, first_name, last_name from workers;

insert into workers (
    --id,
    first_name,
    last_name)
values (
           --1,
           'john', 'smith');

insert into workers (
    --id,
    first_name,
    last_name,
    middle_name)
values (
           --1,
           'ivanka', 'ivanova', 'ivanovna');


select id, first_name || ' ' || workers.middle_name || ' ' || last_name
    --as
    "full_name"
from workers;


select first_name, last_name
from workers
order by first_name
--asc;
;

select first_name, last_name
from workers
order by first_name desc;


select distinct first_name
from workers
order by last_name;

select *
from workers
where id <> 1; --!=, >, <, >=..., AND, OR, IS NULL, NOT, IN, BETWEEN, LIKE...


select *
from workers
where middle_name is not null;


select *
from workers
where first_name in ('ivan', 'ivanka');


alter table workers add column age int;


select  *
from workers
where workers.age between 17 and 42
limit 1 offset  2;


select  *
from workers
order by first_name
offset 2 rows
    fetch first 3 row only ;


select length(first_name) f_n_size, length(last_name) l_n_size
from workers
where id = 1;

select  *
from workers
--where first_name like 'ivan%'
where last_name like 'ivano_' --varchar
order by first_name;


-- нормализация - 1НФ, 2НФ, 3НФ


create table order_2(
                        id serial primary key ,
                        item varchar(100)
);


select
    o_1.id, o_1.item, o_2.id, o_2.item
from order_1 o_1
         join order_2 o_2
              on o_1.item = o_2.item;

select
    o_1.id, o_1.item, o_2.id, o_2.item
from order_1 o_1
         left join order_2 o_2
                   on o_1.item = o_2.item;

select
    o_1.id, o_1.item, o_2.id, o_2.item
from order_1 o_1
         full join order_2 o_2
                   on o_1.item = o_2.item;


create table payment (
                         id serial primary key ,
                         buyer_id int default 1,
                         amount decimal default 100,
                         payment_date date default now()
);

--insert into payment(buyer_id, amount, payment_date) DEFAULT VALUES ;

select *
from payment
where amount > 30
group by buyer_id, id, amount, payment_date -- grouping sets ((id), (id, amount))
having payment_date < now();


--grouping()

select buyer_id, sum(amount) summa --, grouping(payment_date)
from payment
where amount > 30
group by buyer_id, id, amount, payment_date
having payment_date < now();


create table books1 (
                        title varchar not null unique ,
                        year smallint
);

create table books2 (
                        title varchar not null,
                        year smallint
);


select * from books1
union -- intersect, except
select * from books2;


select *
from books1
where (select * from books1 where title  = 'onegin');

update books1
set title = 'Evgeny Onegin'
where title = 'onegin';

/*
update t1
set c = v1
from  t2
where t1.t2_id = t2.id;

 */

delete from books1
where title = 'onegin';


insert into books1 (title, year) values ('onegin', 09-11-2023) --i++
on conflict (title)
    do update set year = now();

begin ; --rollback
insert into books1 (title, year)
values ('', now());
insert into books1 (title, year)
values ('', now());--exception
insert into books1 (title, year)
values ('2', now());
commit;--success

--rollback;
--



























