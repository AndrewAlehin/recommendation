DROP TABLE IF EXISTS user_table cascade;
DROP TABLE IF EXISTS coordination cascade;
DROP TABLE IF EXISTS history cascade;
DROP SEQUENCE IF EXISTS global_seq_user cascade;

CREATE SEQUENCE global_seq_user START WITH 100000;

create table user_table
(
    id   INTEGER primary key DEFAULT nextval('global_seq_user'),
    name varchar(40) not null
);

create table coordination
(
    id           INTEGER primary key DEFAULT nextval('global_seq_user'),
    test         integer not null,
    news         integer not null,
    articles     integer not null,
    math         integer not null,
    russian      integer not null,
    physics      integer not null,
    history      integer not null,
    coordination integer not null,
    user_id      integer not null,
    FOREIGN KEY (user_id) REFERENCES user_table (id) ON DELETE CASCADE
);

create table history
(
    id      INTEGER primary key DEFAULT nextval('global_seq_user'),
    name    varchar(40) not null,
    date    timestamp           default now(),
    user_id integer     not null,
    FOREIGN KEY (user_id) REFERENCES user_table (id) ON DELETE CASCADE
);