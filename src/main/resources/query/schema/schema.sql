create table scheduler(id integer identity primary key, title varchar(200) not null, contents LONGVARCHAR not null, type int, starttime timestamp, endtime timestamp, allDay BOOLEAN, writer varchar(200) not null);
create table category(id integer identity primary key, title varchar(200) not null, groupid varchar(10), writer varchar(200));
create table article(id integer identity primary key, title varchar(200) not null, contents LONGVARCHAR not null, regtime DATE, modtime DATE, writer varchar(200), categoryid integer);

create table apiuser(userKey varchar(200), origin varchar(200) not null, used int);