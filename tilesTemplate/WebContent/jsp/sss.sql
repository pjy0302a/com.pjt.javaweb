SELECT *
FROM   bbs_member;

UPDATE bbs_notice
SET    ntc_to_date = ntc_from_date + 7
WHERE  1 = 1;

SELECT *
FROM   bbs_notice;

CREATE TABLE b_board(id VARCHAR2(10)
                    ,passwd VARCHAR2(20)
                    ,NAME VARCHAR2(30));

SELECT id       "id"
       ,password "password"
       ,NAME     "name"
       ,role     "role"
FROM   b_users;

SELECT *
FROM   b_users;

INSERT INTO b_users
VALUES
    ('user1'
    ,'user1'
    ,'user1'
    ,'user');
INSERT INTO b_users
VALUES
    ('user2'
    ,'user2'
    ,'user2'
    ,'user');

SELECT *
FROM   users; -- busersVO
