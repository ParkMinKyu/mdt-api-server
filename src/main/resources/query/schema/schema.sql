create table scheduler(id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, type int, starttime timestamp, endtime timestamp, allDay BOOLEAN, writer varchar(200) not null);
create table article(id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, regtime timestamp, modtime timestamp, writer varchar(200));
create table apiuser(userKey varchar(200), origin varchar(200) not null, used int);

insert into scheduler values(1, 'test', 'testdddd', 0, NOW(), NOW(),true, 'parkmk');
insert into article values(1, 'test1', 'testdddd1', NOW(), NOW(), 'parkmk');
insert into article values(2, 'test2', 'testdddd2', NOW(), NOW(), 'parkmk');
insert into article values(3, 'test3', 'testdddd3', NOW(), NOW(), 'parkmk');
insert into article values(4, 'test4', 'testdddd4', NOW(), NOW(), 'parkmk');
insert into article values(5, 'test5', 'testdddd5', NOW(), NOW(), 'parkmk');
insert into article values(6, 'test6', 'testdddd6', NOW(), NOW(), 'parkmk');
insert into apiuser values('testmyweb', 'http://parkminkyu.github.io', 0);
insert into apiuser values('testmyweb', 'http://localhost:8080', 0);