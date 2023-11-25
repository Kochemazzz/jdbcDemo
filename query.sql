CREATE TABLE phonebook(
    idphonebook SERIAL PRIMARY KEY ,
    lastname varchar(40),
    phone numeric
);



CREATE TABLE phonebook(
                          idphonebook INTEGER ,
                          lastname varchar(40),
                          phone numeric
);

INSERT INTO phonebook(lastname, phone) VALUES
                                           ('Ivanov', 777777777);

INSERT INTO phonebook(lastname, phone) VALUES
    ('Petrova', 999999999);

INSERT INTO phonebook(lastname, phone) VALUES
    ('Ivanova', 777777776);

SELECT idphonebook,lastname, phone FROM phonebook;


CREATE OR REPLACE PROCEDURE display_msg(INOUT msg TEXT)
AS $$
    BEGIN
        RAISE NOTICE 'Alarm: %', msg;
    end;
    $$
LANGUAGE plpgsql;

call display_msg('Hello!');