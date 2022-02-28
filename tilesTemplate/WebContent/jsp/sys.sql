SELECT *
FROM   tab;

CREATE USER bbs identified BY bbs;

grant CONNECT, RESOURCE TO bbs;

drop TABLE notice purge;

CREATE TABLE notice(id NUMBER primary key
                   ,title VARCHAR2(100)
                   ,content VARCHAR2(1000)
                   ,wdate DATE
                   ,hit NUMBER);

CREATE TABLE member(member_id VARCHAR2(10) primary key
                   ,member_name VARCHAR2(100)
                   ,member_password VARCHAR2(30)
                   ,member_address VARCHAR2(300));

SELECT *
FROM   member;

CREATE sequence notice_seq;

CREATE TABLE bbs(bbs_id NUMBER primary key
                ,bbs_title VARCHAR2(100)
                ,bbs_content VARCHAR2(1000)
                ,bbs_image VARCHAR2(100)
                ,bbs_writer VARCHAR2(30)
                ,bbs_create_date DATE
                ,bbs_hit NUMBER);
