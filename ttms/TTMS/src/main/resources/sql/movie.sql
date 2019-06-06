use ttms;
drop table movie;
create table movie(
  id int primary key AUTO_INCREMENT,
  moviename varchar(50) not null unique,
  photo  varchar(50),
  type varchar(50) default "暂无分类" not null,
  duration int default 0 not null,
  introduction varchar(200) default "暂无简介。" not null,
  release_date date default "2020-12-31" not null,
  score float(1) default 0,
  author char(20) default "暂无作者" not null
);

alter table movie add column  production varchar(200);