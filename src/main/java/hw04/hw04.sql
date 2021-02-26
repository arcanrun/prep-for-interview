--postgresql
------------- ddl-------------------
create database cinema;

create table if not exists movie
(
    id       serial primary key,
    title    varchar(255),
    duration int
);

create table if not exists session
(
    id       serial primary key,
    movie_id int,
    datetime timestamp,
    price    float,
    constraint movie_id_fk foreign key (movie_id) REFERENCES movie (id)
);

create table if not exists ticket
(
    id         serial primary key,
    session_id int,
    constraint session_id_fk foreign key (session_id) REFERENCES session (id)
);


------------------ getSessionFactory data -----------------------------------
insert into movie (title, duration)
values ('Terminator', 60),
       ('Terminator-2', 60),
       ('Terminator-3', 90),
       ('Terminator-4', 120),
       ('Terminator-5', 120);

insert into session (movie_id, datetime, price)
values (1, '2004-10-19 09:00:00', 100.0),
       (1, '2004-10-19 10:00:00', 150.0),
       (2, '2004-10-19 10:30:00', 200.0),
       (3, '2004-10-19 14:00:00', 300.0),
       (4, '2004-10-19 18:00:00', 400.0);

insert into ticket (session_id)
values (1),
       (1),
       (1),
       (1),
       (1),
       (1),
       (2),
       (2),
       (2),
       (3),
       (3),
       (3),
       (4),
       (1),
       (4),
       (1),
       (1),
       (1),
       (1),
       (1),
       (3),
       (2),
       (4);
-------------------------------- some manipulations --------------------------------------------
-- наложение занчений...???
select m.title, s.datetime, m.duration from movie m inner join session s on m.id = s.movie_id

-- перерывы 30 минут и более
