CREATE TABLE operation(
    id serial primary key,
    id_mailing integer, 
    operation text, 
    dates text, 
    mailing_post integer not null references mailing, 
    department integer    
);

CREATE TABLE mailing(
    id serial primary key, 
    id_mailing integer,
    mailing_type text NOT NULL, 
    recipient_index text NOT NULL, 
    adress_recipient text NOT NULL, 
    name_recipient text NOT NULL, 
    status text NOT NULL
);

CREATE TABLE post_department(
    id serial, 
    id_mailing integer,
    index_post integer, 
    title text NOT NULL, 
    address_recipient text NOT NULL
);


