DELETE
FROM user_table;
DELETE
FROM coordination;
DELETE
FROM history;
alter sequence global_seq_user restart with 100000;

INSERT INTO user_table (name)
VALUES ('Ivan'),
       ('Anton'),
       ('Kate'),
       ('Mary'),
       ('Petr'),
       ('Semen'),
       ('Mark'),
       ('July'),
       ('Liza'),
       ('Andrew');

INSERT INTO coordination (test, news, articles, math, russian, physics, history, coordination, user_id)
VALUES (3, 1, 2, 4, 3, 2, 1, 7, 100000),
       (2, 1, 1, 1, 3, 2, 3, 5, 100001),
       (4, 1, 5, 2, 4, 5, 5, 11, 100002),
       (2, 2, 3, 1, 1, 2, 3, 6, 100003),
       (2, 2, 4, 5, 5, 4, 4, 10, 100004),
       (1, 5, 5, 2, 3, 4, 1, 9, 100005),
       (1, 2, 2, 4, 5, 4, 3, 9, 100006),
       (2, 4, 2, 2, 2, 1, 3, 6, 100007),
       (1, 1, 3, 5, 4, 3, 3, 8, 100008),
       (5, 2, 2, 5, 3, 1, 2, 8, 100009);

INSERT INTO history (name, user_id)
values ('articles_history', 100000),
       ('test_history', 100000),
       ('news_math', 100001),
       ('test_physics', 100001),
       ('test_history', 100002),
       ('news_history', 100002),
       ('articles_history', 100003),
       ('news_math', 100003),
       ('articles_russian', 100004),
       ('articles_history', 100004),
       ('test_math', 100005),
       ('test_history', 100005),
       ('news_physics', 100006),
       ('news_math', 100006),
       ('news_math', 100007),
       ('test_russian', 100007),
       ('news_history', 100008),
       ('test_history', 100008),
       ('test_math', 100009),
       ('test_physics', 100009);