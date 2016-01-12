create table scheduler(id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, type int, starttime timestamp, endtime timestamp, allDay BOOLEAN, writer varchar(200) not null);
create table article(id int primary key, title varchar(200) not null, contents LONGVARCHAR not null, regtime timestamp, modtime timestamp, writer varchar(200));
create table apiuser(userKey varchar(200) primary key, origin varchar(200) not null, used int);

insert into scheduler values(1, 'test', 'testdddd', 0, NOW(), NOW(),true, 'parkmk');
insert into apiuser values('testmyweb', 'http://parkminkyu.github.io', 0);